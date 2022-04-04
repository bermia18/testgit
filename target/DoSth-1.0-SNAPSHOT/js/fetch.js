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