## Notes

**Expression Language**
- The JSF deferred expressions are available **during the page postback as well as the page initial rendering**, which means that the JSF deferred expressions can be evaluated in the request processing and the response rendering phases of the JSF framework, while the JSP immediate expressions are available **ONLY during the page rendering** (NOT the page postback) because they are evaluated once the page is rendered for the first time.
- *This means that the JSP EL is always read-only value expressions, while the JSF EL can work in both read and write modes.*

