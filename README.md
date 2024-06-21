# SCM (Supply Chain Management) and CRM (Customer Relationship Management)

I ) Different services under this SCM api's : 

Order service (manages order and product details) [need to fix order-id based mapping]

Inventory service (manages supplier's inventory) (done all working)

Shipping service (has the shipping details) [estimated delivery date should be min 2-3 days of purchase]

Invoice service (generate bill) 

Delivery service (track where the order is using google maps) (track by order id or shipment number)(like swiggy we need to track where the order is like that vehicle moving kind of) [need to save delivery statuses of orders in delivery table]

Jira integration for customer issue management 

Payment gateway integration [Create a Razorpay account and generate API keys.
Add the Razorpay Java SDK to your project.]


II) Different services under this CRM api's :

Customer Management Service: This service would handle all operations related to customer data, such as creating, updating, and retrieving customer profiles. It would also manage customer segmentation and provide customer analytics.

Lead and Opportunity Management Service: This service would be responsible for managing leads, opportunities, and the sales pipeline. It would handle lead generation, qualification, and conversion to opportunities

Marketing Automation Service: This service would handle marketing campaigns, email marketing, and lead nurturing. It would integrate with the lead and opportunity management service

Analytics and Reporting Service: This service would provide advanced analytics and reporting capabilities, allowing users to gain insights into customer behavior, sales performance, and marketing effectiveness [yet to be developed]

Authentication and Authorization Service: This service would handle user authentication, authorization, and access control across the CRM system. [yet to be developed]

Notification Service: This service would be responsible for sending notifications, alerts, and updates to users and customers via email, SMS, or other channels
