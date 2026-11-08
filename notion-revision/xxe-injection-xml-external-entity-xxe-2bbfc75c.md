# XXE Injection: XML External Entity (XXE)

Source: https://app.notion.com/p/2bbfc75cbbd9806f924efe8dc746ec82?pvs=204

XXE is a vulnerability where an application <b>parses XML input that allows external entities</b>. Attackers exploit this to make the XML parser load <b>files, URLs, or system resources </b>that should never be accessible.

XML supports “entities,” which are like variables.

If the parser allows <b>external entities</b>, attackers can define one that points to a <b>local file or remote server</b>.

Then the application <b>expands</b> the entity → leaking data or causing unwanted actions.

```xml
<?xml version="1.0"?>
<!DOCTYPE x [
  <!ENTITY secret SYSTEM "file:///etc/passwd">
]>
<root>
  <data>&secret;</data>
</root>

```

## <b>What is an Entity in XML?</b>

An <b>entity</b> in XML is basically a <b>placeholder</b> or <b>variable</b> that the XML parser replaces with some value when processing the document.

Think of it as a <i>shortcut</i> or <i>reference</i> to data.

---

## <b>Two Main Types</b>

### <b>1. Internal Entity</b>

Defined inside the XML.

<code><!ENTITY myName "Habiba"></code>

Usage: <code><user>&myName;</user></code>

The parser replaces <code>&myName;</code> with <b>Habiba</b>.

---

### <b>2. External Entity</b>

Points to an external <b>file</b> or <b>URL</b>.

Example:

```xml
<!ENTITY secret SYSTEM "file:///etc/passwd">
```

Usage:

```xml
<data>&secret;</data>
```

The parser will try to <b>load the file</b> and replace the entity with its contents.
