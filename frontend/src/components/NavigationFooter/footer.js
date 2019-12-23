import React from "react";

const footer = (props) => {

    return (
        <div className="footer-basic">
            <footer>
                <div className="social"><a href="#"><i className="fa fa-instagram"></i></a><a href="#"><i
                    className="fa fa-twitter"></i></a><a href="#"><i className="fa fa-facebook-f"></i></a>
                </div>
                <ul className="list-inline">
                    <li className="list-inline-item"><a href="#">Home</a></li>
                    <li className="list-inline-item"><a href="#">Menu</a></li>
                    <li className="list-inline-item"><a href="#">Locations</a></li>
                    <li className="list-inline-item"><a href="#">About</a></li>
                    <li className="list-inline-item"><a href="#">Contact</a></li>
                </ul>
                <p className="copyright">Mama Mia's Pizzeria @&nbsp;2020</p>
            </footer>
        </div>
    );

}

export default footer;