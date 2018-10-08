function getData() {
    // Get the data from endpoint.
    $.ajax({
        url:"http://localhost:8080/api/airport/",
        type:"get",
        success: function(airports) {
            $('#airportTable').DataTable().clear();
            $('#airportTable').DataTable().rows.add(airports);
            $('#airportTable').DataTable().columns.adjust().draw();
        }
    });
}

$(document).ready(function () {
    // Load DataTable with data format.
    $('#airportTable').DataTable({
        columns: [
            { "data": "id" },
            { "data": "location" },
            { "data": "airplanes.length" }
            ]
    });

    // Load first data.
    getData();
});