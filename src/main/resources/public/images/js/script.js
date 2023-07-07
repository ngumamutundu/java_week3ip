// WildTracker Script

// Function to handle form submission
function handleFormSubmit(event) {
    event.preventDefault(); // Prevent the default form submission

    // Get the form input values
    const animalId = document.getElementById('animalId').value;
    const location = document.getElementById('location').value;
    const rangerName = document.getElementById('rangerName').value;

    // Create an object with the form data
    const formData = {
        animalId,
        location,
        rangerName
    };

    // Send the form data to the server
    fetch('/sightings', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
    })
    .then(response => response.json())
    .then(data => {
        // Handle the response from the server
        console.log('Sighting created:', data);
        // Perform any necessary actions after successful form submission
    })
    .catch(error => {
        // Handle any errors that occur during form submission
        console.error('Error creating sighting:', error);
    });
}

// Add event listener to the form submit button
const form = document.getElementById('sightingForm');
form.addEventListener('submit', handleFormSubmit);
