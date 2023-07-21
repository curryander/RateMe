window.addEventListener("load", () => {
	document.querySelector("#reg_registration").addEventListener("click", register);
});


const isEmpty = (value) => value === undefined || value === null || value.length === 0;

function register(e) {
	e.preventDefault();

	if (!checkFirstname()) return;
	if (!checkLastname()) return;
	if (!checkStreet()) return;
	if (!checkStreetNr()) return;
	if (!checkPlz()) return;
	if (!checkCity()) return;
	if (!checkEmail()) return;
	if (!checkUsername()) return;
	if (!checkPassword()) return;

	registration();
	//logoutToken();

}

function checkFirstname() {
	const nameElem = document.querySelector("#firstname");

	if (isEmpty(nameElem.value)) {
		showError(nameElem, "Pflichtfeld");
	} else if (!isValidName(nameElem.value)) {
		showError(
			nameElem,
			"Muss mit einem Großbuchstabe beginnen. Darf keine Sonderzeichen enthalten."
		);
	} else {
		showSuccess(nameElem);
		return true;
	}

	return false;
}

function checkLastname() {
	const nameElem = document.querySelector("#firstname");

	if (isEmpty(nameElem.value)) {
		showError(nameElem, "Pflichtfeld");
	} else if (!isValidName(nameElem.value)) {
		showError(
			nameElem,
			"Muss mit einem Großbuchstabe beginnen. Darf keine Sonderzeichen enthalten."
		);
	} else {
		showSuccess(nameElem);
		return true;
	}

	return false;
}

const isValidName = (name) => {
	const re = /^[A-Z]+[^\d§$%&!?]*[a-z]$/;
	return re.test(name);
};



function checkStreet() {
	const streetElem = document.querySelector("#street");

	if (isEmpty(streetElem.value)) {
		showError(streetElem, "Pflichtfeld");
	} else {
		showSuccess(streetElem);
		return true;
	}

	return false;
}

function checkStreetNr() {
	const streetNrElem = document.querySelector("#streetNr");

	if (isEmpty(streetNrElem.value)) {
		showError(streetNrElem, "Pflichtfeld");
	} else if (!isValidNumber(streetNrElem.value)) {
		showError(streetNrElem, "Nummer nicht gültig");
	} else {
		showSuccess(streetNrElem);
		return true;
	}

	return false;
}


const isValidNumber = (number) => {
	const re = /^[0-9]{1,4}$/;
	return re.test(number);
};


function checkPlz() {
	const plzElem = document.querySelector("#plz");

	if (isEmpty(plzElem.value)) {
		showError(plzElem, "Pflichtfeld");
	} else if (!isValidPlz(plzElem.value)) {
		showError(plzElem, "PLZ ist nicht gültig");
	} else {
		showSuccess(plzElem);
		return true;
	}

	return false;
}

const isValidPlz = (plz) => {
	const re = /^[0-9]{5}$/;
	return re.test(plz);
};

function checkCity() {
	const cityElem = document.querySelector("#city");

	if (isEmpty(cityElem.value)) {
		showError(cityElem, "Pflichtfeld");
	} else {
		showSuccess(cityElem);
		return true;
	}

	return false;
}


function checkEmail() {
	const mailElem = document.querySelector("#e-mail");

	if (isEmpty(mailElem.value)) {
		showError(mailElem, "Pflichtfeld");
	} else if (!isValidMail(mailElem.value)) {
		showError(mailElem, "Nur E-Mail-Adressen von Studenten der Hochschule Kaiserslautern erlaubt");
	} else {
		showSuccess(mailElem);
		return true;
	}

	return false;
}

const isValidMail = (mail) => {
	const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@(stud.hs-kl.de)$/;
	return re.test(String(mail).toLowerCase());
};

async function checkUsername() {
	const usernameElem = document.querySelector("#username");

	if (isEmpty(usernameElem.value)) {
		showError(usernameElem, "Pflichtfeld");
	}
	/*else if ((await getUsernameExists(usernameElem.value.trim())) === true) {
		showError(usernameElem, "Username ist bereits vergeben.");
	}*/ else {
		showSuccess(usernameElem);
		return true;
	}

	return false;
}


const showError = (input, message) => {
	// get the form-field element
	const formField = input.parentElement;
	// add the error class
	formField.classList.remove("success");
	formField.classList.add("error");

	// show the error message
	const error = formField.querySelector("small");
	error.textContent = message;
};

const showSuccess = (input) => {
	// get the form-field element
	const formField = input.parentElement;

	// remove the error class
	formField.classList.remove("error");
	formField.classList.add("success");

	// hide the error message
	const error = formField.querySelector("small");
	error.textContent = "";
};

function checkPassword() {
	const passwordElem = document.querySelector("#password");
	const veryweak = document.querySelector(".veryweak");
	const weak = document.querySelector(".weak");
	const medium = document.querySelector(".medium");
	const good = document.querySelector(".good");
	const strong = document.querySelector(".strong");

	const mediumRegex = /(?=.*[a-z])(?=.*[A-Z])/;
	const goodRegex = /(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[^A-Za-z0-9])/;

	let strength = 0;

	if (passwordElem.value.length < 5) {
		strength = 1;
	} else if (
		passwordElem.value.length > 7 &&
		mediumRegex.test(passwordElem.value) &&
		goodRegex.test(passwordElem.value)
	) {
		strength = 5;
	} else if (mediumRegex.test(passwordElem.value) && goodRegex.test(passwordElem.value)) {
		strength = 4;
	} else if (mediumRegex.test(passwordElem.value)) {
		strength = 3;
	} else {
		strength = 2;
	}

	switch (strength) {
		case 1:
			veryweak.classList.add("active");
			weak.classList.remove("active");
			medium.classList.remove("active");
			good.classList.remove("active");
			strong.classList.remove("active");
			return true;

		case 2:
			veryweak.classList.add("active");
			weak.classList.add("active");
			medium.classList.remove("active");
			good.classList.remove("active");
			strong.classList.remove("active");
			return true;

		case 3:
			veryweak.classList.add("active");
			weak.classList.add("active");
			medium.classList.add("active");
			good.classList.remove("active");
			strong.classList.remove("active");
			return true;

		case 4:
			veryweak.classList.add("active");
			weak.classList.add("active");
			medium.classList.add("active");
			good.classList.add("active");
			strong.classList.remove("active");
			return true;

		case 5:
			veryweak.classList.add("active");
			weak.classList.add("active");
			medium.classList.add("active");
			good.classList.add("active");
			strong.classList.add("active");

		default:
			veryweak.classList.remove("active");
			weak.classList.remove("active");
			medium.classList.remove("active");
			good.classList.remove("active");
			strong.classList.remove("active");
			return true;
	}
}
