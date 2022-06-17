function loadTasks(){
    fetch('./api/tasks/')
        .then(function (response){

            response.json().then(function (data){
                let tasks = document.getElementById("work");
                let tasks2 = document.getElementById("hobby");
                let finish = document.getElementById("done");


                tasks.innerHTML = "";
                tasks2.innerHTML = "";
                finish.innerHTML = "";
                console.log(data);
                data.forEach(function (d){
                    if(d.checked){
                        finish.innerHTML += "<div class='tasks'> " + d.title + "</div>" +
                            "</br>";
                    }
                    else if(d.type == "saveFromWork") {
                        tasks.innerHTML += "<div class='tasks'> " + d.title +
                            "<input onclick='checkedState(" + d.id + ")' style='float: right; margin-right: 10%; margin-top: 12px;' type='checkbox' value='"+ d.id +"' id='flexCheckDefault' > </div>" +
                            "</br>";
                    }
                    else if(d.type == "saveFromHobbys"){
                        tasks2.innerHTML += "<div class='tasks'> " + d.title +
                            "<input onclick='checkedState(" + d.id + ")' style='float: right; margin-right: 10%; margin-top: 12px;' type='checkbox' value='"+ d.id +"' id='flexCheckDefault' >  </div>" +
                            "</br>";
                    }
                })

            })
        })
}

function checkedState(id){
    fetch('./api/tasks/' + id,
        {method : 'PUT'})
        .then(
            function (response) {
                loadTasks();
            })
}





function loadSuggestions(){
    fetch('./api/suggestions/')
        .then(function (response){
            response.json().then(function (data){
                let suggestions = document.getElementById("suggestionField");

                suggestions.innerHTML = "";

                for(var i = 0; i < data.length; i++){
                    suggestions.innerHTML += "<div class='innerSuggestion'> <div style='margin-left: 15%; margin-top:2%;'>" + data[i].title + "</div><button class='addSuggestion' onclick='addSuggestion(" + i + ")'>Add</button>" + "</div>" + "</br>";
                }

            })
        })
}

function addSuggestion(id){
    fetch('./api/suggestions/' + id, {
        method:"POST"
    }).then(function (response){
        counter = counter + 1;
        removeSuggestion(id);
    })
}

function removeSuggestion(id){
    fetch('./api/suggestions/' + id, {
        method: "DELETE"
    }).then(function (response){
        loadSuggestions();

    })

}

function newSuggestions(){
    fetch('./api/suggestions/', {
        method: 'POST'
    }).then(function (response){
        loadSuggestions();
    })
}

let counter = 0;
let name = null;
function getId(id){
    name = id;
}

function addTask(){
    counter = counter+1;
    const title = document.getElementById('title').value;
    const type = name;
    const from = document.getElementById('startDate').value;
    const to = document.getElementById('endDate').value;
    const description = document.getElementById('comment').value;
    const checked = false;

    if((title && type && from && to && description) == "" || (title && type && from && to && description) == null ){
        alert("Bitte alles ausfüllen!");
        return;
    }

    if(to < from){
        alert("Angegebener Zeitraum ist nicht korrekt");
        return;
    }

    const task = {counter, type, title, from, to, description, checked};


        fetch('./api/tasks/', {
            method: 'POST',
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(task)
        }).then(
            function (response) {
                document.getElementById("title").value="";
                document.getElementById("startDate").value="";
                document.getElementById("endDate").value="";
                document.getElementById("comment").value="";
                loadTasks();
            }
        )


}
