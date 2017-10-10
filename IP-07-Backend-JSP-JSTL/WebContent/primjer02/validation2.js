function validateForm()
{
    var x=document.forms["brojevi"]["broj1"].value;
    var y=document.forms["brojevi"]["broj2"].value;
    var validator1 = document.getElementById('broj1validation');

    // Restart
    validator1.innerHTML = '';

    if (x==null || x=="") {
      alert("Unesite prvi broj!");
       validator1.innerHTML = 'Unesite prvi broj!';
      return false;
      }
    if (!parseInt(x)) {
        alert("Niste unijeli broj!");
        return false;
    }
    if (y==null || y=="") {
      alert("Unesite drugi broj!");
      return false;
      }
    if (!parseInt(x)) {
        alert("Niste unijeli broj!");
        return false;
    }
      return z;
}

