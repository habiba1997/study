# Errors

Source: https://app.notion.com/p/32efc75cbbd98023b541c34da48a5aab?pvs=204

<page url="https://app.notion.com/p/32efc75cbbd980268ac7fc194bb04d63">
<code>[ERROR] 'java.util.Set org.junit.platform.engine.TestDescriptor.getAncestors()'</code>
</page>

our test only stubs:

- <code>translate(any(), Issuer.class)</code> → <code>generateIssuer()</code>
- <code>translate(stagedCredentialAward, Award.class)</code> → <code>awardResult</code>

So when the real code runs, the <b>second</b> call is:

<code>translate(CredentialOrganization, Organization.class)</code>

That call <b>does not match</b> either stub (wrong source type and wrong target class). With <code>@ExtendWith(MockitoExtension.class)</code>, Mockito uses <b>strict stubbing</b>: it treats that as a mistake and throws <code>PotentialStubbingProblem</code> instead of quietly returning <code>null</code> for an “unstubbed” overload.

ith JUnit Jupiter you can relax strictness in a few ways.

### <b>1. Whole test class (most common)</b>

import org.mockito.junit.jupiter.MockitoSettings;

import org.mockito.quality.Strictness;

@ExtendWith(MockitoExtension.class)

@MockitoSettings(strictness = Strictness.LENIENT)

class MyTest \{

<i>// ...</i>

\}

### <b>2. Only some stubs</b>

import static org.mockito.Mockito.lenient;

lenient().when(mock.foo()).thenReturn(...);

### <b>3. Single mock (less common)</b>

@Mock(strictness = Mock.Strictness.LENIENT)

private MyService service;
