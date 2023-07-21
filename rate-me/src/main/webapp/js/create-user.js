function registration() {
    let user = {
        firstname: document.querySelector("#firstname").value,
        lastname: document.querySelector("#lastname").value,
        street: document.querySelector("#street").value,
        streetNr: document.querySelector("#streetNr").value,
        zip: document.querySelector("#plz").value,
        city: document.querySelector("#city").value,
        email: document.querySelector("#e-mail").value,
        username: document.querySelector("#username").value,
        password: document.querySelector("#password").value,
    };

    console.log("user for signup: " + JSON.stringify(user));

    fetch("app/user", {
        method: "post",
        headers: {
            "Content-type": "application/json",
        },
        body: JSON.stringify(user),
    })
        .then((response) => {
            return response.json();
        })
        .then((data) => {
            console.log("Login Token " + JSON.stringify(data));

            //logoutToken(data.token);
            alert("Registrierung erfolgreich!");
        })
        .catch((error) => {
            console.error("Error:", error);
        });

}
/*
async function getUsernameExists(username) {
    return fetch("app/controller/user/" + username + "?checkExists=true", {
        method: "get",
    })
        .then((response) => {
            if (response.ok) return true;
            return false;
        })
        .catch((error) => {
            console.error("Error checking user exists: ", error);
        });
        }
        */