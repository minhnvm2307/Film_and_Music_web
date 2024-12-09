document.getElementById('submit').addEventListener('click', function() {
    const name = document.getElementById('name').value;

    fetch(`/greet?name=${encodeURIComponent(name)}`)
        .then(response => response.text())
        .then(data => {
            document.getElementById('result').innerText = data;
        })
        .catch(error => console.error('Error:', error));
});

document.getElementById('reload').addEventListener('click', function() {
    window.location.reload();
});
