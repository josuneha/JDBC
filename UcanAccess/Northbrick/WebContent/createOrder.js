tableOrder = document.getElementById('order');

function newOrderLine() {
    
    var tr1 = document.createElement("TR");
    tableOrder.appendChild(tr1);
    createCell(tr1, 'OrderDate');
    createCell(tr1, 'EmployeeID');

    var td1 = document.createElement("TD");
    var in1 = document.createElement("INPUT");
    in1.setAttribute("type", 'submit');
    in1.setAttribute("value", 'Save');
    td1.appendChild(in1);
    tr1.appendChild(td1);

}
function createCell(tr1, name) {
        var td1 = document.createElement("TD");
        var in1 = document.createElement("INPUT");
        in1.setAttribute("name", name);
        in1.setAttribute("placeholder", name);
        td1.appendChild(in1);
        tr1.appendChild(td1);
}
function addNew() {
		

    var in1 = document.createElement("INPUT");
    in1.setAttribute("type", 'button');
    in1.setAttribute("name", 'Save');
    
	in1.onclick = function() {newOrderLine();};
    in1.setAttribute("value", 'createOrder');
    document.body.insertBefore(in1, tableOrder);
}
addNew();