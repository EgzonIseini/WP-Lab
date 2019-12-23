import React from "react";

const landing = (props) => {

    return (
        <div className="container">
            <div className="row text-center d-lg-flex justify-content-lg-center">
                <div className="col-12 text-center d-lg-flex d-xl-flex justify-content-lg-center"
                     style={{ marginTop: "2em" }}>
                    <h1 className="d-block" style={{
                        fontFamily: "'Alfa Slab One', cursive", fontSize: "61px"
                    }}>Welcome
                        to</h1>
                </div>
                <div
                    className="col-12 text-left d-sm-flex d-lg-flex justify-content-sm-center justify-content-lg-center">
                    <img className="img-fluid d-block" src="pizzaLogo.png" /></div>
                <div className="col-12 text-center d-lg-flex justify-content-lg-center" style={{ marginBottom: "2em" }}>
                    <h1 className="d-block" style={{ fontFamily: "'Alfa Slab One', cursive", fontSize: "61px" }}>Mama Mia's
                        Pizzeria</h1>
                </div>
            </div>
        </div>
    );
}

export default landing;