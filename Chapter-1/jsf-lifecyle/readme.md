
### Notes

- “Non Postback” requests: The “Non Postback” request refers to a new request to a page. If this case, the Restore View phase creates an empty UI components tree and stores it in the current FacesContext instance. For the “Non Postback” requests, the JSF life cycle directly proceeds to the last phase, which is the “Render Response” phase. In the “Render Response” phase, the empty UI components tree is populated with the JSF components in the page. Also, the UI components tree state is saved in the JSF view state for the next requests.

- “Postback” requests: The “Postback” request occurs when the content of the form is submitted to the same page using the HTTP POST method. In this case, the Restore View phase restores the UI components tree from the JSF view state that was generated from the previous page request.
