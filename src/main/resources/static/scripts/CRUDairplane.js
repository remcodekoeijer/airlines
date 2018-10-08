function getData() {
    // Get the data from endpoint.
    $.ajax({
        url:"http://localhost:8080/api/airplane/",
        type:"get",
        success: function(airplanes) {
            // On successful get, reload the datatable with new data.
            console.log("This is the data: " + airplanes);
            $('#airplaneTable').DataTable().clear();
            $('#airplaneTable').DataTable().rows.add(airplanes);
            $('#airplaneTable').DataTable().columns.adjust().draw();
        }
    });
}

//function postData() {
//    console.log("posting data...");
//
//    // Get values from html.
//    var birdName = $("input[type=text][name=birdName]").val();
//    var flying = $( "input[type=radio][name=flying]:checked" ).val();
//    var numberOfEggs = $( "input[type=number][name=numberOfEggs]" ).val();
//    console.log("birdname: " + birdName);
//    console.log("flying: " + flying);
//    console.log("numberofeggs: " + numberOfEggs);
//
//    // Create JS object with data.
//    var newBird = {
//        name : birdName,
//        flying : flying,
//        numberOfEggs : numberOfEggs
//    };
//    console.log(newBird);
//
//    // Convert JS object to JSON.
//    var validJsonBird = JSON.stringify(newBird);
//    console.log(validJsonBird);
//
//    // Post JSON to endpoint.
//    $.ajax({
//        url:"http://localhost:8080/api/birds",
//        type:"post",
//        data: validJsonBird,
//        contentType: "application/json",
//        success: function(result) {
//            // On successful post, reload data to get the added one as well.
//            console.log("success post data!");
//            getData();
//        }
//    });
//}

function addFuel(planeID) {
    console.log("plane id: " + planeID);

    $.ajax({
        url:"http://localhost:8080/api/airplane/" + planeID,
        type:"put",
        success: function(result) {
            console.log("success add fuel data!");
            getData();
        }
    });
}

$(document).ready(function () {
    // Modal submit.
//    $("#newBookForm").on('submit', function(e) {
//        console.log("Submitted new book form");
//
//        // Post the data from the modal.
//        postData();
//
//        // Reset modal to hide and no values.
//        $('#newBookModal').modal('hide');
//        $("#inputTitle").val("");
//        $("#inputAuthor").val("");
//    });

    // Load DataTable with data format.
    $('#airplaneTable').DataTable({
        columns: [
            { "data": "id" },
            { "data": "currentFuel" },
            { "data": function() {
                       return '<button onclick="addFuel(this.parentElement.parentElement.children[0].innerText)" type="button" class="btn btn-danger">Add fuel</button>' }}
        ]
    });

    // Load first data.
    getData();
});