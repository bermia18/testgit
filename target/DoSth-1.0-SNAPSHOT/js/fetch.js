const interval = setInterval(function (){
    loadSuggestions();
}, 30000)

function testfun(){
    alert("hello");
}

function loadTasks(){
    fetch('./api/tasks/')
        .then(function (response){

            response.json().then(function (data){
                let tasks = document.getElementById("work");
                let tasks2 = document.getElementById("hobby");


                tasks.innerHTML = "";
                tasks2.innerHTML = "";

                data.forEach(function (d){
                    if(d.type == "saveFromWork") {
                        tasks.innerHTML += "<div class='tasks'> " + d.title + "</div>" +
                            "</br>";
                    }
                    if(d.type == "saveFromHobbys"){
                        tasks2.innerHTML += "<div class='tasks'> " + d.title + "</div>" +
                            "</br>";
                    }
                })
            })
        })
}

let id = 0;
let name = null;
function getId(id){
    name = id;
}

function loadSuggestions(){
    fetch('./api/suggestions')
        .then(function (response){
            response.json().then(function (data){
                let suggestions = document.getElementById("suggestionField");

                suggestions.innerHTML = "";

                for(var i = 0; i < data.length; i++){
                    suggestions.innerHTML += "<div class='innerSuggestion'> " + data[i].title + "<button class='addSuggestion' onclick='removeSuggestion(" + i + ")'>Add</button>" + "</div>" + "</br>";
                }
            })
        })
}

function addSuggestion(index){
    removeSuggestion(index);
    const task = {id: 7, type: 'saveFromWork', title: 'GIMME GIMME', from: new Date('1220-12-02'), to: new Date('2022-12-02'), description: 'Da is was', checked: false};

    fetch('./api/tasks/', {
        method: 'POST',
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(task)
    }).then(
        function (response) {
            document.getElementById("title").value="";
            document.getElementById("startDate").value="";
            document.getElementById("endDate").value="";
            document.getElementById("descripiton").value="";
            loadTasks();
        }
    )
}

function removeSuggestion(index){
    fetch('./api/suggestions/' + index, {
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
    id = id+1;
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

    const task = {id, type, title, from, to, description, checked};

        fetch('./api/tasks/', {
            method: 'POST',
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(task)
        }).then(
            function (response) {
                document.getElementById("title").value="";
                document.getElementById("startDate").value="";
                document.getElementById("endDate").value="";
                document.getElementById("descripiton").value="";
                loadTasks();
            }
        )
}


