import React from "react";

const sampleFunction = (props) => {

    let handleClick = (e) => {
        console.log("THIS. IS. SPARTAAAA.")
    }

    let message = "e";

    props.status ? message = "Successful" : message = "Failed";

    return (
        <div style={{
            border: '1px solid black',
            margin: '3px',
            padding: '2px',
            width: '20%'
        }}>
            <p><b>Status is:</b> {message}</p>
            <h3>{props.description}</h3>
            <button onClick={handleClick}>Save</button>
        </div>
    );
}

export default sampleFunction;