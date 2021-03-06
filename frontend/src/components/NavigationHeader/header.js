import React from "react";
import { Link, NavLink } from "react-router-dom";

const Header = (props) => {

    return (
        <header>
            <nav className="navbar navbar-light navbar-expand-md sticky-top bg-light text-capitalize shadow">
                <div className="container-fluid"><Link to={"/"}  className="navbar-brand" data-bs-hover-animate="pulse"
                                                    style={{
                                                        fontFamily: "'Alfa Slab One', cursive",
                                                        fontSize: "22px",
                                                        padding: "5px 5px",
                                                        marginRight: "30px"
                                                    }}><img
                    className="img-fluid" src="pizzaLogo.png" height="100%" width="60rem"
                    style={{marginRight: "1em"}}  alt={"Pizzeria Logo"}/>Mama Mia's Pizzeria</Link>
                    <button
                        data-toggle="collapse" className="navbar-toggler" data-target="#navcol-1"><span className="sr-only">Toggle navigation</span><span
    className="navbar-toggler-icon"/></button>
                    <div className="collapse navbar-collapse" id="navcol-1">
                        <ul className="nav navbar-nav">
                            <li className="nav-item" role="presentation"><NavLink to={"/"} activeClassName={"active"} exact className="nav-link">Home</NavLink>
                            </li>
                            <li className="nav-item" role="presentation"><NavLink to={"/ingredients"} activeClassName={"active"} className="nav-link">Ingredients</NavLink></li>
                            <li className="nav-item" role="presentation"><NavLink to={"/pizzas"} activeClassName={"active"} className="nav-link" href="#">Pizzas</NavLink></li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>
    );
}

export default Header;