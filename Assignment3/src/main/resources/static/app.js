function addEmployee() {
    const firstName = document.getElementById('firstName').value;
    const lastName = document.getElementById('lastName').value;
    const employeeID = parseInt(document.getElementById('employeeID').value);
    const designation = document.getElementById('designation').value;
    const knownLanguagesAndScores = document.getElementById('knownLanguagesAndScores').value;
    
    

    // Split the input into an array of language-score pairs
    const languageScorePairs = knownLanguagesAndScores.split(',').map(pair => pair.trim());

    // Create an array to store language objects
    const knownLanguages = [];

    // Parse each language-score pair and create language objects
    for (const pair of languageScorePairs) {
        const [language, score] = pair.split(':');
        
        // Validate the score (you can add more validation as needed)
        const scoreOutof100 = parseInt(score) || 0;

        // Create a language object and add it to the array
        knownLanguages.push({
            languageName: language,
            scoreOutof100: scoreOutof100
        });
    }

    const newEmployee = {
        firstName: firstName,
        lastName: lastName,
        employeeID: employeeID,
        designation: designation,
        knownLanguages: knownLanguages
    };

    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/employees/add',
        contentType: 'application/json',
        data: JSON.stringify(newEmployee),
        success: function(response) {
            document.getElementById('result').innerText = response;
        },
        error: function(error) {
            document.getElementById('result').innerText = error.responseText;
        }
    });
}



function searchEmployee() {
    const searchTerm = document.getElementById('searchTerm').value;

    $.ajax({
        type: 'GET',
        url: `http://localhost:8080/employees/search?searchTerm=${searchTerm}`,
        success: function(response) {
            displayResult(response);
        },
        error: function(error) {
            document.getElementById('result').innerText = error.responseText;
        }
    });
}

function displayResult(data) {
    let result = '<h3>Search Result:</h3>';
    
    if (data.length > 0) {
        result += '<ul>';
        data.forEach(employee => {
            const formattedResult = `${employee.firstName} ${employee.lastName} - ${employee.designation}`;
            result += `<li>${formattedResult.replace(/[\r\n]+/g, '')}</li><br>`;
            // The replace(/[\r\n]+/g, ' ') removes \n and \r characters
        });
        result += '</ul>';
    } else {
        result += '<p>No matching employees found.</p>';
    }

    document.getElementById('result').innerHTML = result;
}


function deleteEmployee() {
    const deleteEmployeeID = parseInt(document.getElementById('deleteEmployeeID').value);

    $.ajax({
        type: 'DELETE',
        url: `http://localhost:8080/employees/delete/${deleteEmployeeID}`,
        success: function(response) {
            document.getElementById('result').innerText = response;
        },
        error: function(error) {
            document.getElementById('result').innerText = error.responseText;
        }
    });
}

function updateDesignation() {
    const updateEmployeeID = parseInt(document.getElementById('updateEmployeeID').value);
    const newDesignation = document.getElementById('newDesignation').value;

    $.ajax({
        type: 'PUT',
        url: `http://localhost:8080/employees/${updateEmployeeID}`,
        contentType: 'application/json',
        data: JSON.stringify(newDesignation),
        success: function(response) {
            document.getElementById('result').innerText = response;
        },
        error: function(error) {
            document.getElementById('result').innerText = error.responseText;
        }
    });
}

function getJavaExperts() {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/employees/javaExperts',
        success: function(response) {
            displayResult(response);
        },
        error: function(error) {
            document.getElementById('result').innerText = error.responseText;
        }
    });
}

function displayResult(data) {
    let result = '<pre>' + JSON.stringify(data, null, 2) + '</pre>';
    document.getElementById('result').innerHTML = result;
}
