import React from "react";
import "./App.css";

import { Container, Row, Col } from "react-bootstrap";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import CreateStudentComponent from "./components/CreateStudentComponent";
import ListStudentComponent from "./components/ListStudentComponent";
import ViewStudentComponent from "./components/ViewStudentComponent";
import UpdateStudentComponent from "./components/UpdateStudentComponent";
import NavigationBar from "./components/NavigationBar";
import Register from "./components/User/Register";
import Login from "./components/User/Login";
import Footer from "./components/Footer";
import Home from "./components/Home";


const App = () => {
  window.onbeforeunload = (event) => {
    const e = event || window.event;
    e.preventDefault();
    if (e) {
      e.returnValue = "";
    }
    return "";
  };

  return (
    <Router>
      <NavigationBar />
      <Container>
        <Row>
          <Col lg={12} className={"margin-top"}>
            <Switch>
              <Route path="/" exact component={Home} />
              <Route path="/home" exact component={Home} />
              <Route path="/students" component={ListStudentComponent}></Route>
              <Route path="/view-student/:id" component={ViewStudentComponent}></Route>
              <Route path="/add-student/_add" component={CreateStudentComponent}></Route>
              <Route path="/update-student/:id" component={UpdateStudentComponent}></Route>
              <Route path="/register" exact component={Register} />
              <Route path="/login" exact component={Login} />
              <Route
                path="/logout"
                exact
                component={() => (
                  <Login message="Kullanıcı Başarıyla Çıkış Yaptı..!!" />
                )}
              />
            </Switch>
          </Col>
        </Row>
      </Container>
      <Footer />
    </Router>
  );
};

export default App;
