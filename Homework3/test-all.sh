# Devon Gadarowski 2019
# Based on the test-all scripts created by Dr. Sean Szumlanski

testcases=(
	"TreeOperations"
	"NullRoot"
	"BalancedExample"
	"UnbalancedExample"
	"JustRoot"
)

num_pass=0
num_cases=0

# print header

printf "\n%17s%28s\n" "TestCase" "Result"

echo "===================================================="

for testcase in ${testcases[@]};
do
	((num_cases++))
	printf %-34s $testcase.java

	rm -f *.class
	rm -f output.txt

	# Check if the test case compiles
	javac $testcase.java 2> /dev/null
	compile_value=$?
	if [ $compile_value != 0 ]; then
		echo "Failed to Compile!"
		continue
	fi

	rm -f *.class

	# Check if the test case throws warning messages
	javac -Werror $testcase.java -Xlint:unchecked 2> /dev/null
	compile_value=$?
	if [ $compile_value != 0 ]; then
		echo "Compiled with warnings!"
		continue
	fi

	# Check if the test case crashes
	java $testcase > output.txt 2> /dev/null
	runtime_value=$?
	if [ $runtime_value != 0 ]; then
		echo "Crashed!"
		continue
	fi

	# Check if the output is correct
	diff output.txt sample_output/$testcase.txt > /dev/null 2> /dev/null
	diff_value=$?
	if [ $diff_value != 0 ]; then
		echo "Wrong Answer!"
		continue
	fi

	echo "PASS"
	((num_pass++))
done

echo "===================================================="
echo

if [ $num_pass == $num_cases ]; then
	echo "Great work! :)" 
	echo "Make sure you go ahead and test your submission on the Eustis Test Server before submitting."
	echo "Don't forget to make some test cases of your own."
else
	echo "Don't be discouraged. You are doing great."
	echo "If you need help, please come talk to the Professor or one of the TAs during"
	echo "office hours, or send us a message on Webcourses with your problem."
fi

rm -f *.class
rm -f output.txt
