import React from "react";

const ingredientRow = (props) => {

    return (
        <tr>
            <td>{props.name}</td>
            <td>{props.amount}</td>
            <td>{props.spicy}</td>
            <td>{props.veggie}</td>
            <td className="d-lg-flex justify-content-lg-center align-items-lg-start" style={{ width: "100%" }}><a
                className="btn btn-primary" role="button" data-toggle="tooltip" data-bs-tooltip=""
                style={{marginRight: "0.5em"}} title="Edit" href="#"><i className="fa fa-edit"/></a>
                <button className="btn btn-danger" data-toggle="tooltip"
                        data-bs-tooltip="" type="button" style={{ marginRight: "0.5em" }} title="Remove"><i
    className="fa fa-trash-o"/></button>
                <a className="btn btn-success" role="button" data-toggle="tooltip" data-bs-tooltip="" title="Details"
                   href="#"><i className="fa fa-th-list"/></a></td>
        </tr>
    )
};

export default ingredientRow;