function loadTasks(){
    fetch('./api/tasks/')
        .then(function (response){

            response.json().then(function (data){
                let tasks = document.getElementById("work");


                data.forEach(function (d){
                    tasks.innerHTML += "<div class='tasks'> " + d.title + "</div>" +
                    "</br>";
                })

            })
        })
}

function loadSuggestions(){
    fetch('./api/suggestions')
        .then(function (response){
            response.json().then(function (data){
                let suggestions = document.getElementById("suggestionField");

                suggestions.innerHTML = "";

                for(var i = 0; i < data.length; i++){
                    suggestions.innerHTML += "<div class='innerSuggestion'> " + data[i].title + "<button class='addSuggestion' onclick='addSuggestion(" + i + ")'>Add</button>" + "</div>" + "</br>";
                }

            })
        })
}

function addSuggestion(id){
    removeSuggestion(id);
}

function removeSuggestion(id){
    fetch('./api/suggestions/' + id, {
        method: "DELETE"
    })
    loadSuggestions();
}

function newSuggestions(){
    fetch('./api/suggestions', {
        method: 'POST'
    })

    loadSuggestions();
}

function addTask(){
    const title = document.getElementById('title');
    const start = document.getElementById('startDate');
    const end = document.getElementById('endDate');
    const comment = document.getElementById('comment');


}
