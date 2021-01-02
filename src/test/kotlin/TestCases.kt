import com.forthreal.application.classes.ParenthesesParser
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue

class TestCases
{
    @Test
    public fun testCase1()
    {
        assertTrue( ParenthesesParser.checkBalanced( "( ( (( )( )) ) () )" ) )
    }

    @Test
    public fun testCase2()
    {
        assertTrue( ParenthesesParser.checkBalanced( "( ( **( )( )* ) (*)* *" ) )
    }

    @Test
    public fun testCase3()
    {
        assertFalse( ParenthesesParser.checkBalanced( "(() (( ))" ))
    }


    @Test
    public fun testCase4()
    {
        assertFalse( ParenthesesParser.checkBalanced( ") * () )" ))
    }

    @Test
    public fun testCase5()
    {
        assertFalse( ParenthesesParser.checkBalanced( ")))****" ))
    }

    @Test
    public fun testCase6()
    {
        assertFalse( ParenthesesParser.checkBalanced( "())****" ))
    }


    @Test
    public fun testCase7()
    {
        assertTrue( ParenthesesParser.checkBalanced( "** () *)" ))
    }

}