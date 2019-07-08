function productList() {
	// Call Web API to get a list of Product
	$.ajax({
		url : '/orders/orders',
		type : 'GET',
		dataType : 'json',
		success : function(icecreamList) {
			productListSuccess(icecreamList);
		},
		error : function(request, message, error) {
			handleException(request, message, error);
		}
	});
}

function productListSuccess(icecreamList) {
	// Iterate over the collection of data
	$.each(icecreamList, function(index, product) {
		// Add a row to the Product table
		productAddRow(product);
	});
}

function productAddRow(product) {
	// Will Check if <tbody> tag exists, add one if not
	if ($("#productTable tbody").length == 0) {
		$("#productTable").append("<tbody></tbody>");
	}
	// Append row to <table>
	$("#productTable tbody").append(productBuildTableRow(product));
}


function productBuildTableRow(product) {
    var ret = "<tr>" + "<td>" + product.id + "</td>"
    				 + "<td>" + product.cname + "</td>" 	
					 + "<td>" + product.name + "</td>" 
					 + "<td>" + product.price + "</td>" 
					 + "<td>" + product.qty + "</td>" 
					 + "<td>" + product.total + "</td>" 
			  + "</tr>";
    return ret;
}

function handleException(request, message, error) {
	var msg = "";
	msg += "Code: " + request.status + "\n";
	msg += "Text: " + request.statusText + "\n";
	if (request.responseJSON != null) {
		msg += "Message" + request.responseJSON.Message + "\n";
	}
	alert(msg);
}