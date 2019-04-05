
## Notes
### Restore View
- **“Non Postback” requests**: The “Non Postback” request refers to a new request to a page. If this case, the Restore View phase creates an empty UI components tree and stores it in the current FacesContext instance. **For the “Non Postback” requests, the JSF life cycle directly proceeds to the last phase, which is the “Render Response” phase**. In the “Render Response” phase, the empty UI components tree is populated with the JSF components in the page. Also, the UI components tree state is saved in the JSF view state for the next requests.
- **“Postback” requests**: The “Postback” request occurs when the content of the form is submitted to the same page using the HTTP POST method. In this case, the Restore View phase restores the UI components tree from the JSF view state that was generated from the previous page request.

### Apply Request Values
- Note The “Apply Request Values” is applied to all the components which have a value attribute. In JSF, the components which have the value attribute must **implement the ValueHolder interface**. In order to apply the request values to all the value holder nodes in the UI components tree, the JSF runtime calls the processDecodes() method of the UIViewRoot , which causes the child components’ processDecodes() method to be called as well in order to apply the request values for all of them.

### Process Validations
- In order to apply the process validations in the UI components tree, the JSF runtime calls the processValidators() method of the UIViewRoot , which causes the child components’ processValidators() method to be called as well in order to apply the conversion and the validation to all of them.

### Update Model Values
- In order to perform the model values update, the JSF runtime calls the processUpdates() method of the UIViewRoot , which causes the child components’ processUpdates() method to be called as well in order to apply the model updates to all of them. However, the UIInput components override the processUpdates() method in order to call the updateModel() for binding the user input with the managed bean property.

### Invoke Application
- In order to perform the “Invoke Application” phase, the JSF runtime calls the processApplication() method of the UIViewRoot , which broadcasts the queued events to the UICommand components (or any other UIComponent that implements the ActionSource interface or ActionSource2 interface [which was introduced in JSF 1.2]) by calling the broadcast(FacesEvent event) method of the UIComponent . The broadcast method broadcasts the action event to all of the action listeners registered to this event type for processing.

### The Immediate Attribute
- The *<h:link>* and *<h:button>* are new components that have been introduced since JSF 2.0; they can be used to implement the GET navigation to target pages using the outcome attribute.
- The *<h:commandLink>* and *<h:commandButton>* implement the POST request.
- Adding to the UICommand components, the immediate attribute can be applied to the EditableValueHolder components (such as the input text). If the *immediate attribute is set to true for an EditableValueHolder component*, ***the conversion and the validation of the EditableValueHolder components will be executed in the “Apply Request Values” phase (before the “Process Validations” phase, this phase could be supposed to skip).***

>- **If set in UIInput(s) only**, the process validations phase will be taken place in apply request values phase instead. Use this to prioritize validation for the UIInput component(s) in question. When validation/conversion fails for any of them, the non-immediate components won't be validated/converted.
>- **If set in UICommand only**, the apply request values phase until with update model values phases will be skipped for any of the UIInput component(s). Use this to skip the entire processing of the form. E.g. "Cancel" or "Back" button.
>- **If set in both UIInput and UICommand components**, the apply request values phase until with update model values phases will be skipped for any of the UIInput component(s) which does not have this attribute set. Use this to skip the processing of the entire form expect for certain fields (with immediate). E.g. "Password forgotten" button in a login form with a required but non-immediate password field.
[Read BalusC's article](http://balusc.omnifaces.org/2006/09/debug-jsf-lifecycle.html)