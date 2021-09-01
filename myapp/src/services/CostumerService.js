 import axios from "axios";

  const COSTUMER_API_BASE_URL= "http://localhost:8080/costumers"
class CostumerService{
     getCostumers(){
         return axios.get(COSTUMER_API_BASE_URL);
     }
      createCostumer(costumer){
         return axios.post(COSTUMER_API_BASE_URL,costumer);
     }
     getCostumersById(costumerId){
         return axios.get(COSTUMER_API_BASE_URL+ '/' + costumerId);
     }
    
     updateCostumer(costumer, costumerId){
        return axios.put(COSTUMER_API_BASE_URL+ '/'+ costumerId, costumer);
     }
     deleteCostumer( costumerId){
        return axios.delete(COSTUMER_API_BASE_URL+ '/'+ costumerId);
     }
     

}

export default new CostumerService()