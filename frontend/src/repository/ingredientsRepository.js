import axios from '../custom-axios/axios'
import qs from 'qs'

const IngredientService = {
    fetchIngredients: () => {
        return axios.get("/ingredients")
    },

    pushIngredient: (ingredient) => {
        const formParams = qs.stringify(ingredient)

        return axios.post("/ingredients", formParams, {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            }
        });
    },

    deleteIngredient: (ingredientId) => {
        return axios.delete(`/ingredients/${ingredientId}`)
    },

    updateIngredient: (ingredientId, newIngredient) => {
        const formParams = qs.stringify(newIngredient);

        return axios.patch("/ingredients/" + ingredientId, formParams, {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            }
        });
    },

    fetchPizzasWithIngredient: (ingredientId) => {
        return axios.get("/ingredients/"+ingredientId+"/pizzas")
    }
};

export default IngredientService;