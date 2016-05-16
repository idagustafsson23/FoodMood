
  $(function() {
    $( "#priceslider" ).slider({
      range: true,
      min: 0,
      max: 5000,
      values: [ 75, 300 ],
      slide: function( event, ui ) {
        $( "#amount" ).val(   ui.values[ 0 ] + "kr - " + ui.values[ 1 ] + "kr" );
      }
    });
    $( "#amount" ).val($( "#priceslider" ).slider( "values", 0 ) +
      "kr - " + $( "#priceslider" ).slider( "values", 1 ) + "kr" );


    
   
  });

