/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

function setCheck(obj){
    var fries = document.getElementsByName('cidd');
    if((obj.id==='c0') && (fries[0].checked===true)){
      for(var i=1 ;i<fries.length ; i++)
          fries[i].checked =false;
        
        
    }else{
        for(var i=1; i< fries.length ;i++){
            if(fries[i].checked===true){
                fries[0].checked=false;
                break;
            }
        }
    }
    document.getElementById('f1').submit();
}


function setCheck1(obj){
    var fries = document.getElementsByName('price');
    if((obj.id==='g0') && (fries[0].checked===true)){
      for(var i=1 ;i<fries.length ; i++)
          fries[i].checked =false;
        
        
    }else{
        for(var i=1; i< fries.length ;i++){
            if(fries[i].checked===true){
                fries[0].checked=false;
                break;
            }
        }
    }
    document.getElementById('f2').submit();
}
function setCheck2(obj){
    var fries = document.getElementsByName('cat');
    if((obj.id==='ok0') && (fries[0].checked===true)){
      for(var i=1 ;i<fries.length ; i++)
          fries[i].checked =false;
        
        
    }else{
        for(var i=1; i< fries.length ;i++){
            if(fries[i].checked===true){
                fries[0].checked=false;
                break;
            }
        }
    }
    document.getElementById('f2').submit();
}

/* Set rates + misc */
var taxRate = 0.05;
var shippingRate = 15.00; 
var fadeTime = 300;


/* Assign actions */
$('.product-quantity input').change( function() {
  updateQuantity(this);
});

$('.product-removal button').click( function() {
  removeItem(this);
});


/* Recalculate cart */
function recalculateCart()
{
  var subtotal = 0;
  
  /* Sum up row totals */
  $('.product').each(function () {
    subtotal += parseFloat($(this).children('.product-line-price').text());
  });
  
  /* Calculate totals */
  var tax = subtotal * taxRate;
  var shipping = (subtotal > 0 ? shippingRate : 0);
  var total = subtotal + tax + shipping;
  
  /* Update totals display */
  $('.totals-value').fadeOut(fadeTime, function() {
    $('#cart-subtotal').html(subtotal.toFixed(2));
    $('#cart-tax').html(tax.toFixed(2));
    $('#cart-shipping').html(shipping.toFixed(2));
    $('#cart-total').html(total.toFixed(2));
    if(total == 0){
      $('.checkout').fadeOut(fadeTime);
    }else{
      $('.checkout').fadeIn(fadeTime);
    }
    $('.totals-value').fadeIn(fadeTime);
  });
}


/* Update quantity */
function updateQuantity(quantityInput)
{
  /* Calculate line price */
  var productRow = $(quantityInput).parent().parent();
  var price = parseFloat(productRow.children('.product-price').text());
  var quantity = $(quantityInput).val();
  var linePrice = price * quantity;
  
  /* Update line price display and recalc cart totals */
  productRow.children('.product-line-price').each(function () {
    $(this).fadeOut(fadeTime, function() {
      $(this).text(linePrice.toFixed(2));
      recalculateCart();
      $(this).fadeIn(fadeTime);
    });
  });  
}


/* Remove item from cart */
function removeItem(removeButton)
{
  /* Remove row from DOM and recalc cart total */
  var productRow = $(removeButton).parent().parent();
  productRow.slideUp(fadeTime, function() {
    productRow.remove();
    recalculateCart();
  });
}
