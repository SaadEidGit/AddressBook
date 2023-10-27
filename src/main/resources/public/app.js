$(document).ready(function () {
    $.ajax({
        url: "http://localhost:8080/addressBook?addressBookId=1"
    }).then(function (data) {
        if (data) {
            $('.addressbook-id').append("Address Book ID: " + data.id);
            for (i = 0; i < data.buddies.length; i++) {
                $('.addressbook-contents')
                .append("Name: " + data.buddies[i].name).append("<br>")
                .append("Phone Number: " + data.buddies[i].phoneNumber).append("<br>")
                .append("Address: " + data.buddies[i].address).append("<br>");
            }
        }
    });
});