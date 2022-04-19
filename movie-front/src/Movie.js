import React from "react";
import LikeAndDislike from "./LikeAndDislike";

class Movie extends React.Component {

    render() {
        return (
            <div className="movie">
                <h1 className="display-1">{this.props.title}</h1>
                <div className="row">
                    <div className="col">
                        <img src={this.props.poster} alt='Poster' className="img-fluid"/>
                    </div>
                    <div className="col-8">
                        <h4>Description:</h4>
                        <p>
                            {this.props.desc}
                        </p>
                        <LikeAndDislike id={this.props.id} likes={this.props.likes} dislikes={this.props.dislikes}/>
                    </div>
                </div>
            </div>
        );
    }
}

export default Movie;