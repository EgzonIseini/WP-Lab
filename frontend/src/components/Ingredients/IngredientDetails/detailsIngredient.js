import React, {useEffect, useState} from "react";
import {Link, useParams, useHistory} from "react-router-dom";
import axios from '../../../custom-axios/axios'
import PizzaList from '../IngredientPizzaTable/ingredientPizzaTable'

const detailsIngredient = (props) => {

    const [ingredient, setIngredient] = useState({});
    const {ingredientId} = useParams();
    const history = useHistory();

    useEffect(() => {
        axios.get("/ingredients/"+ingredientId).then((data)=>{
            setIngredient(data.data);
        }).catch(() => {
            history.push("/ingredients");
        })
    },[])


    const isVeggie = ingredient.veggie ? "True" : "False",
        isSpicy = ingredient.spicy ? "True" : "False";

    return (

        <div className="container" style={{ padding: "5rem 1rem 5rem 1rem" }}>
            <div className="card">
                <div className="card-body">
                    <h4 className="card-title">{ingredient.name}</h4>
                    <h6 className="text-muted card-subtitle mb-2">Ingredient Details</h6>
                    <form>
                        <div className="form-group">
                            <div className="form-row">
                                <div className="col-6">
                                    <div className="input-group m-2">
                                        <div className="input-group-prepend"><span
                                            className="input-group-text">Name</span></div>
                                        <input type="text" className="form-control" name="ingredientName" value={ingredient.name} disabled/>
                                    </div>
                                    <div className="input-group m-2">
                                        <div className="input-group-prepend"><span
                                            className="input-group-text">Amount</span></div>
                                        <input type="number" className="form-control" name="ingredientAmount" value={ingredient.amount} disabled/>
                                    </div>
                                </div>
                                <div className="col-6">
                                    <div className="input-group m-2">
                                        <div className="input-group-prepend"><span
                                            className="input-group-text">Spicy</span></div>
                                        <input type="text" className="form-control" name="ingredientSpicy" value={isSpicy} disabled/>
                                    </div>
                                    <div className="input-group m-2">
                                        <div className="input-group-prepend"><span
                                            className="input-group-text">Veggie</span></div>
                                        <input type="text" className="form-control" name="ingredientVeggie" value={isVeggie} disabled/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                    <h6 className="display-4">Pizzas with this Ingredient:</h6>
                        <PizzaList ingredientId={ingredient.id}/>
                    <Link to="/ingredients" className="btn btn-success" role="button">Back</Link>
                </div>
            </div>
        </div>

    );
}

export default detailsIngredient;