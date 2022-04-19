import React from "react";

class LikeAndDislike extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            updating: false,
            likes: this.props.likes,
            dislikes: this.props.dislikes,
        };
        this.setState = this.setState.bind(this);
        this.handleDislike = this.handleDislike.bind(this);
        this.handleLike = this.handleLike.bind(this);
    }

    async handleLike() {
        this.setState({updating: true});
        const response = await likeMovie(this.props.id);
        this.setState({
            likes: response.like,
            dislikes: response.dislike,
            updating: false,
        });
    }

    async handleDislike() {
        this.setState({updating: true});
        const response = await dislikeMovie(this.props.id);
        this.setState({
            likes: response.like,
            dislikes: response.dislike,
            updating: false,
        });
    }

    render() {
        if (this.state.updating) {
            return (
                <div>
                    <li>
                        Likes: ...
                        <button className="btn btn-outline-danger btn-sm" onClick={this.handleLike}>Like</button>
                    </li>
                    <li>
                        Dislikes: ...  
                        <button className="btn btn-outline-secondary btn-sm" onClick={this.handleDislike}>Dislike</button>
                    </li>
                </div>
            );
        }
        else {
            return (
                <div>
                    <li>
                        Likes: {this.state.likes}   
                        <button className="btn btn-outline-danger btn-sm" onClick={this.handleLike}>Like</button>
                    </li>
                    <li>
                        Dislikes: {this.state.dislikes}   
                        <button className="btn btn-outline-secondary btn-sm" onClick={this.handleDislike}>Dislike</button>
                    </li>
                </div>
            );
        }
    }
}

function likeMovie(id) {
    const url = "http://localhost:8080/api/movies?opt=like&id="+id;
    const response = fetch(url, {method:'PUT', mode: 'cors'})
                        .then(response => response.json());
    return response;
}
  
function dislikeMovie(id) {
    const url = "http://localhost:8080/api/movies?opt=dislike&id="+id;
    const response = fetch(url, {method:'PUT', mode: 'cors'})
    .then(response => response.json());
    return response;
}

export default LikeAndDislike;