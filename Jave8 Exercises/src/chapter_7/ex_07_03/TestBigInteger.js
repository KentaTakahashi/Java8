print('called js start');

var b = new java.math.BigInteger('1234567890987654321');
print(b);
print(b.mod(java.math.BigInteger.TEN));
printf('%d', Number(b));
var b2 = b.toString();
print(b2);
print('called js end');