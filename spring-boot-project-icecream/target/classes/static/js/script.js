function pickicecream() {
	// assign the select
	var inamelist = document.getElementById("name").value;
	console.log(inamelist); // Display the selected value in the console

	if (inamelist == "Select Ice_Cream") {
		document.getElementById("price").value = 0;
	} else if (inamelist == "Vanilla Icecream") {
		document.getElementById("price").value = 200;
	} else if (inamelist == "Chocolate Icecream") {
		document.getElementById("price").value = 200;
	} else if (inamelist == "Blueberry Icecream") {
		document.getElementById("price").value = 300;
	} else if (inamelist == "CheeseCake with Waffle") {
		document.getElementById("price").value = 400;
	}
}

function calTotal() {
	var iprice = document.getElementById("price").value;
	var iqty = document.getElementById("qty").value;
	var total = iprice * iqty;
	document.getElementById("total").value = total;
	console.log(total);
}

//function submitOnClick() {
//	document.getElementById("name").value = "Select Ice-Cream";
//	document.getElementById("price").value = 0;
//	document.getElementById("number").value = 0;
//	document.getElementById("total").value = 0;
//}

//#######################################################################

function updateClick() {
	  // Build product object from inputs
	  var icecream = {id:0 , name:"" , cname: "",  price: 0, qty: 0, total: 0 } //Attributes of the object
	  //icecream = new Object(); //Object for product

	  //bind the user entered values
	  icecream.id = $("#id").val();
	  icecream.cname = $("#cname").val();
	  icecream.name = $("#name").val(); //get the values of form elements "name"
	  icecream.price = $("#price").val();
	  icecream.qty = $("#qty").val();
	  icecream.total = $("#total").val();
	  
	  productAdd(icecream);
	}

function productAdd(icecream) {
	  $.ajax({
	    url: "/",
	    type: 'POST',
	    contentType: "application/json",
	    data: JSON.stringify(icecream),
	    success: function (icecream) 
	    {
	      productAddSuccess(icecream);
	    },
	    error: function (request, message, error) {
	      handleException(request, message, error);
	    }
	  });
	}

function productAddSuccess(icecream) {
	  productAddRow(icecream);
	  formClear();
	}

function formClear() {
	  $("#id").val("");
	  $("#cname").val("");
	  $("#name").val("");
	  $("#price").val("");
	  $("#qty").val("");
	  $("#total").val("");
	}
function addClick() {
	  formClear();
	}