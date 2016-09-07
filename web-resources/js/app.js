'use strict';

const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

class App extends React.Component {

  constructor(props) {
    super(props);
  }

  componentDidMount() {
    console.log("App did mount!");
  }

  render() {
    return (
      <div className="container">
        <h1>Restaurants</h1>
        <LandmarkFilter />
      </div>
    );
  }

}

class LandmarkFilter extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      landmarks: []
    };
  }

  componentDidMount() {
    console.log("LandmarkFilter did mount!");

    client({
      method: 'GET',
      path: '/api/landmarks?size=100&sort=name'
    }).then(response => {
      this.setState({
        landmarks: response.entity._embedded.landmarks
      });
    });
  }

  render() {
    var landmarks = this.state.landmarks.map(landmark =>
      <LandmarkFilterItem key={landmark._links.self.href} landmark={landmark} />
    );
    return (
      <div className="panel-group" id="filter-accordion" role="tablist" aria-multiselectable="true">
        <div className="panel panel-default">
          <div className="panel-heading" role="tab" id="landmark-filter">
            <h6 className="panel-title">
              <a className="collapsed" role="button" data-toggle="collapse" data-parent="#filter-accordion" href="#landmark-filter-detail" aria-expanded="false" aria-controls="landmark-filter-detail">
                <span>Landmark filter</span>
              </a>
            </h6>
          </div>
          <div id="landmark-filter-detail" className="panel-collapse collapse" role="tabpanel" aria-labelledby="landmark-filter">
            <div className="panel-body">
              <ul>
                {landmarks}
              </ul>
            </div>
          </div>
        </div>
      </div>
    );
  }

}

class LandmarkFilterItem extends React.Component {

  constructor(props) {
    super(props);
  }

  componentDidMount() {
    console.log("LandmarkFilterItem did mount!");
  }

  render() {
    return (
      <li>
        <a href={"/restaurants?landmarkId=" + this.props.landmark.id}>{this.props.landmark.name}</a>
      </li>
    );
  }

}

ReactDOM.render(
  <App />,
  document.getElementById('app')
);
