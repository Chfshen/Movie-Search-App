import React from 'react';
import './App.css';
import SearchBar from './SearchBar';
import Movie from './Movie';

class App extends React.Component{

  constructor() {
    super();
    this.state = {
      hasMovie: false,
      content: '',
      title: '',
      desc: '',
      poster: '',
      likes: '',
      dislikes: '',
      id: '',
      isLoading: false,
      notFound: false,
    }
    this.setState = this.setState.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  async handleSubmit(event) {
    event.preventDefault();
    this.setState({isLoading: true});
    const response = await getMovie(this.state.content);
    if (response.id === null)
      this.setState({
        isLoading: false,
        notFound: true,
      });
    else
      this.setState({
        isLoading: false,
        title: response.title,
        desc: response.desc,
        poster: response.poster,
        likes: response.like,
        dislikes: response.dislike,
        id: response.id,
        hasMovie: true,
        notFound: false,
      });
  }

  render() {
    if (this.state.isLoading) {
      return (
        <div>
          <SearchBar changeParentState={this.setState} handleSubmit={this.handleSubmit}/>
          <h1>Loading...</h1>
          <div className="spinner-border" role="status">
            <span className="visually-hidden">Loading...</span>
          </div>
        </div>
      );
    }

    else if (this.state.notFound)
      return (
        <div>
          <SearchBar changeParentState={this.setState} handleSubmit={this.handleSubmit}/>
          <h1>Result Not Found</h1>
        </div>
      );

    else if (this.state.hasMovie) {
      return (
        <div>
          <SearchBar changeParentState={this.setState} handleSubmit={this.handleSubmit}/>
          <Movie id={this.state.id} title={this.state.title} desc={this.state.desc} poster={this.state.poster} likes={this.state.likes} dislikes={this.state.dislikes}/>
        </div>
      );
    }

    else return (
      <div>
        <div>
          <h1 className="display-1 text-center">
            Movie Search App
          </h1>
        </div>
        <div>
          <div className="d-flex align-items-center justify-content-center">
            <SearchBar changeParentState={this.setState} handleSubmit={this.handleSubmit}/>
          </div>
        </div>
      </div>
    );
  }
}

function getMovie(content) {
  const url = "http://localhost:8080/api/movies?content="+content;
  const response = fetch(url, {method:'GET', mode: 'cors'})
                    .then(response => response.json());
  return response;
}

export default App;
