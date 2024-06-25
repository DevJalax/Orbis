# ERP (Enterprise Resource Planning)

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

III) Other ERP apis :

Financial Management Service: This service would handle all financial operations such as accounts payable and receivable, general ledger, budgeting, forecasting, and expense management. It would provide comprehensive financial reporting and analytics.[done]

Human Resource Management Service: This service would manage employee data, payroll processing, time and attendance tracking, performance management, and training and development. It would streamline HR-related operations and provide workforce analytics.[done]

Manufacturing and Production Management Service: This service would handle production planning and control, quality management, maintenance and asset management, shop floor control, and product costing and pricing. It would optimize manufacturing processes and provide real-time production insights.

Project Management Service: This service would enable project planning and scheduling, resource allocation, task management, collaboration, and project reporting. It would help organizations effectively manage projects and track their progress. save's project in Trello.

Business Intelligence and Reporting Service: This service would integrate data from across the organization, provide real-time dashboards and analytics, enable ad-hoc reporting, and deliver predictive insights to support data-driven decision making. i need to integrate these api's into power-bi.[pending development]

Workflow and Process Automation Service: This service would streamline business processes through automated approval workflows, document management, and collaboration tools. It would help optimize operations and improve efficiency. use temporal and rpa to accomplish this task.
[pending development]

Document Microservice: Handles the generation, storage, and management of various financial and business documents within the ERP system.
 
Loan Microservice: Manages the loan-related processes and transactions within the ERP system. 

Investment Microservice: Handles the investment-related functionalities and data within the ERP system. 
 
Log Microservice: Records and manages the financial and system-related logs within the ERP system. 
 
Authentication and Authorization Microservice: Handles the authentication and authorization processes for users and services within the ERP system.

E-commerce microservice: Provides the online storefront, shopping cart, and checkout functionality
