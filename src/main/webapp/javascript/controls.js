
  $(function() {
    $( "#priceslider" ).slider({
      range: true,
      min: 0,
      max: 5000,
      values: [ 75, 300 ],
      slide: function( event, ui ) {
        $( "#amount" ).val( "$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ] );
      }
    });
    $( "#amount" ).val( "$" + $( "#priceslider" ).slider( "values", 0 ) +
      " - $" + $( "#priceslider" ).slider( "values", 1 ) );
    $("#minPrice").val($("priceslider").slider("values", 0));
    $("#maxPrice").val($("priceslider").slider("values", 1));
  });

