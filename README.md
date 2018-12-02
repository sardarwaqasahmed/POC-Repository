# WebRepo
All Web Related projects

## EmailSender
```diff
+ Email Sender is spring boot applicaton that is using JAVAMailServer interface for sending email . Gmail SMPT server is used for demo purpose. Modify the properties files for SMPT setting!
````
## PaymentGatewayInt
```diff
PaymentGatewayInt is spring boot POC project that integrate stripe api for collecting CC info from customers. Kind of Payment gateway integration POC. Once customer initate the request its redirected to payment page, using public key. After getting the client CC related info Stripe will redirect a POST request to this Spring boot app eithet the payment is successfull or failed.
````
