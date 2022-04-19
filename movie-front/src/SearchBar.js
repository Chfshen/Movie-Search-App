import React from 'react';

class SearchBar extends React.Component {

    constructor(props) {
      super(props);
      this.state = {value: ''};
      this.handleChange = this.handleChange.bind(this);
    }
  
    handleChange(event) {
      this.props.changeParentState({content: event.target.value});
      this.setState({value: event.target.value});
    }
  
  
    render() {
      return (
            <form onSubmit={this.props.handleSubmit}>
                <div className="col">
                    <label className="form-label">
                        Title:
                        <input type="text" className="form-control" value={this.state.value} onChange={this.handleChange} />
                    </label>
                </div>
                <div className="col">
                    <input type="submit" className="btn btn-primary" value="Search" />
                </div>
            </form>
      );
    }
}

export default SearchBar;