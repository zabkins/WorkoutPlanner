let deleteButtons = document.querySelectorAll("a#deleteDayBtn");

function confirmAction(idToDelete){
    let confirmAction = confirm("Are you sure you want to delete?")
    if(confirmAction) {
        window.location.href = `http://localhost:8080/tday/delete/${idToDelete}`;
    }
}

deleteButtons[0].getAttribute("href");

deleteButtons.forEach(function (deleteBtn){
    deleteBtn.addEventListener("click",function (event){
        event.preventDefault();
        confirmAction(deleteBtn.getAttribute("href"));
    })
})