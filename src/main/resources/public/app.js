$(document).ready(function () {

    $('#addressBookForm').submit(function (event) {
        event.preventDefault();

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/addressBookCreate",
            success: function (response) {
                $('.addressbook-id').empty();
                $('.addressbook-contents').empty();
                $('.addressbook-id').append("Address Book ID: " + response.id);
            },
            error: function (error) {
                alert("Error: " + error.responseText);
            }
        });
    });

    $('#buddyForm').submit(function (event) {
        event.preventDefault();

        var formData = $('#buddyForm').serialize();

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/buddyAdd",
            data: formData,
            success: function (response) {
                $('.addressbook-contents')
                    .append("Name: " + response.name).append("<br>")
                    .append("Phone Number: " + response.phoneNumber).append("<br>")
                    .append("Address: " + response.address).append("<br>").append("<br>");
            },
            error: function (error) {
                alert("Error: " + error.responseText);
            }
        });
    });
});