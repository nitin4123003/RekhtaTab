$(function(){
var url = "http://localhost:8080/api/getContent";
var quote = $("#quoteblock");// the id of the heading
$.get(url, function (data) {
var the_quote = data;
var response = data;
quote.text(response.sher);
});
});
