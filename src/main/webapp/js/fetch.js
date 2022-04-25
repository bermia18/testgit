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

function addTask(){
    const title = document.getElementById('title');
    const start = document.getElementById('startDate');
    const end = document.getElementById('endDate');
    const comment = document.getElementById('comment');


}
