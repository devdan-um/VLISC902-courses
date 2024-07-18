const curso ={
    name : "matematicas"
    
}
fetch(http://localhost:8080/api/univer/curso,{
method : "POST",
body: JSON.stringify(curso),
headers:{"Content-type" : "aplicattion/json"}
})
.then(response => {
    if(response.ok && response.status ===201){
        console.log(response);
        return response.json()
    }
    
    })
    .then(json =>{
        console.log(json)
}) 