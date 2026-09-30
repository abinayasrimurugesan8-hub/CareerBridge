package com.example.careerbridge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


/* ================================================= */
/*                  MAIN ACTIVITY                    */
/* ================================================= */

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CareerBridgeApp()
        }
    }
}


/* ================================================= */
/*                     COLORS                        */
/* ================================================= */

private val Navy = Color(0xFF080B18)
private val Navy2 = Color(0xFF0D1124)
private val CardColor = Color(0xFF151A32)
private val Purple = Color(0xFF7C4DFF)
private val Blue = Color(0xFF4F8CFF)
private val Gold = Color(0xFFFFC857)
private val White = Color(0xFFF8F8FF)
private val SoftWhite = Color(0xFFB8BCD0)
private val BorderColor = Color(0xFF363B55)


/* ================================================= */
/*                  CAREERBRIDGE LOGO               */
/* ================================================= */

@Composable
fun CareerBridgeLogo(
    size: androidx.compose.ui.unit.Dp
) {
    Image(
        painter = painterResource(id = R.drawable.careerbridge_logo),
        contentDescription = "CareerBridge Logo",
        modifier = Modifier.size(size)
    )
}


/* ================================================= */
/*                MAIN APP NAVIGATION                */
/* ================================================= */

@Composable
fun CareerBridgeApp() {

    var currentScreen by remember {
        mutableStateOf("login")
    }

    when (currentScreen) {

        "login" -> {

            CareerBridgeLogin {
                currentScreen = "home"
            }
        }

        "home" -> {

            CareerBridgeHome(

                onAIChat = {
                    currentScreen = "chat"
                },

                onAssessment = {
                    currentScreen = "assessment"
                },

                onLearning = {
                    currentScreen = "learning"
                },

                onResume = {
                    currentScreen = "resume"
                },

                onInterview = {
                    currentScreen = "interview"
                },

                onProgress = {
                    currentScreen = "progress"
                },

                onLogout = {
                    currentScreen = "login"
                }
            )
        }

        "chat" -> {

            CareerBridgeChat {
                currentScreen = "home"
            }
        }

        "assessment" -> {

            SkillAssessmentScreen {
                currentScreen = "home"
            }
        }

        "learning" -> {

            PersonalizedLearningScreen {
                currentScreen = "home"
            }
        }

        "resume" -> {

            ResumeEvaluationScreen {
                currentScreen = "home"
            }
        }

        "interview" -> {

            InterviewPreparationScreen {
                currentScreen = "home"
            }
        }

        "progress" -> {

            ProgressDashboardScreen {
                currentScreen = "home"
            }
        }
    }
}


/* ================================================= */
/*                    LOGIN SCREEN                   */
/* ================================================= */

@Composable
fun CareerBridgeLogin(
    onLogin: () -> Unit
) {

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    val backgroundGradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF090B1A),
            Color(0xFF11152D),
            Color(0xFF090B18)
        )
    )

    val buttonGradient = Brush.horizontalGradient(
        colors = listOf(
            Purple,
            Blue
        )
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Navy
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundGradient)
                .padding(horizontal = 24.dp),

            contentAlignment = Alignment.Center
        ) {

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                CareerBridgeLogo(78.dp)

                Spacer(Modifier.height(18.dp))

                Text(
                    "CareerBridge",
                    color = White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.height(6.dp))

                Text(
                    "Your Career • Your Future",
                    color = Gold,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )

                Spacer(Modifier.height(28.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(28.dp))
                        .background(CardColor)
                        .padding(24.dp)
                ) {

                    Text(
                        "Welcome Back",
                        color = White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(Modifier.height(5.dp))

                    Text(
                        "Continue your career journey",
                        color = SoftWhite,
                        fontSize = 14.sp
                    )

                    Spacer(Modifier.height(22.dp))

                    Text(
                        "Email",
                        color = White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(Modifier.height(8.dp))

                    OutlinedTextField(
                        value = email,
                        onValueChange = {
                            email = it
                        },

                        modifier = Modifier.fillMaxWidth(),

                        singleLine = true,

                        placeholder = {
                            Text(
                                "Enter your email",
                                color = Color(0xFF777C94)
                            )
                        },

                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email
                        ),

                        shape = RoundedCornerShape(16.dp),

                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Purple,
                            unfocusedBorderColor = BorderColor,
                            focusedTextColor = White,
                            unfocusedTextColor = White,
                            cursorColor = Gold
                        )
                    )

                    Spacer(Modifier.height(17.dp))

                    Text(
                        "Password",
                        color = White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(Modifier.height(8.dp))

                    OutlinedTextField(
                        value = password,
                        onValueChange = {
                            password = it
                        },

                        modifier = Modifier.fillMaxWidth(),

                        singleLine = true,

                        placeholder = {
                            Text(
                                "Enter your password",
                                color = Color(0xFF777C94)
                            )
                        },

                        visualTransformation =
                            PasswordVisualTransformation(),

                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password
                        ),

                        shape = RoundedCornerShape(16.dp),

                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Purple,
                            unfocusedBorderColor = BorderColor,
                            focusedTextColor = White,
                            unfocusedTextColor = White,
                            cursorColor = Gold
                        )
                    )

                    TextButton(
                        onClick = {},
                        modifier = Modifier.align(Alignment.End)
                    ) {

                        Text(
                            "Forgot Password?",
                            color = Gold,
                            fontSize = 13.sp
                        )
                    }

                    Spacer(Modifier.height(8.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .clip(RoundedCornerShape(18.dp))
                            .background(buttonGradient),

                        contentAlignment = Alignment.Center
                    ) {

                        Button(
                            onClick = {
                                onLogin()
                            },

                            modifier = Modifier.fillMaxSize(),

                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent
                            ),

                            shape = RoundedCornerShape(18.dp)
                        ) {

                            Text(
                                "LOGIN  →",
                                color = Color.White,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Spacer(Modifier.height(18.dp))

                    Text(
                        "New to CareerBridge?",

                        modifier = Modifier.fillMaxWidth(),

                        textAlign = TextAlign.Center,

                        color = SoftWhite,

                        fontSize = 13.sp
                    )

                    TextButton(
                        onClick = {}
                    ) {

                        Text(
                            "Create Your Account",
                            color = Gold,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Spacer(Modifier.height(20.dp))

                Text(
                    "AI-Powered Placement Preparation",
                    color = Color(0xFF777C94),
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}


/* ================================================= */
/*                    HOME SCREEN                    */
/* ================================================= */

@Composable
fun CareerBridgeHome(

    onAIChat: () -> Unit,

    onAssessment: () -> Unit,

    onLearning: () -> Unit,

    onResume: () -> Unit,

    onInterview: () -> Unit,

    onProgress: () -> Unit,

    onLogout: () -> Unit
) {

    val modules = listOf(

        CareerModule(
            "🤖",
            "AI Career Assistant",
            "Ask career and placement questions"
        ),

        CareerModule(
            "🎯",
            "Skill Assessment",
            "Test your aptitude and technical skills"
        ),

        CareerModule(
            "📚",
            "Personalized Learning",
            "Get a learning path based on your skills"
        ),

        CareerModule(
            "📄",
            "Resume Evaluation",
            "Improve your resume for placements"
        ),

        CareerModule(
            "🎤",
            "Interview Preparation",
            "Practice interview questions"
        ),

        CareerModule(
            "📊",
            "Progress Dashboard",
            "Track your skills and preparation"
        )
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Navy
    ) {

        LazyColumn(

            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Navy2,
                            Navy
                        )
                    )
                )
                .padding(horizontal = 20.dp),

            verticalArrangement =
                Arrangement.spacedBy(12.dp)
        ) {

            item {

                Spacer(Modifier.height(30.dp))

                Row(

                    modifier = Modifier.fillMaxWidth(),

                    horizontalArrangement =
                        Arrangement.SpaceBetween,

                    verticalAlignment =
                        Alignment.CenterVertically
                ) {

                    Column {

                        Text(
                            "CareerBridge",
                            color = White,
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            "AI Career Companion",
                            color = Gold,
                            fontSize = 12.sp
                        )
                    }

                    TextButton(
                        onClick = {
                            onLogout()
                        }
                    ) {

                        Text(
                            "Logout",
                            color = SoftWhite,
                            fontSize = 12.sp
                        )
                    }
                }

                Spacer(Modifier.height(25.dp))

                Text(
                    "Hello, Student 👋",
                    color = SoftWhite,
                    fontSize = 15.sp
                )

                Spacer(Modifier.height(5.dp))

                Text(
                    "Build Your Future",
                    color = White,
                    fontSize = 29.sp,
                    fontWeight = FontWeight.ExtraBold
                )

                Spacer(Modifier.height(5.dp))

                Text(
                    "Prepare smarter. Learn better. Get placed.",
                    color = SoftWhite,
                    fontSize = 13.sp
                )

                Spacer(Modifier.height(25.dp))

                Column(

                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(24.dp))
                        .background(
                            Brush.horizontalGradient(
                                colors = listOf(
                                    Color(0xFF242052),
                                    Color(0xFF182A55)
                                )
                            )
                        )
                        .padding(20.dp)
                ) {

                    Text(
                        "Your Preparation",
                        color = White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(Modifier.height(8.dp))

                    Text(
                        "Start your journey towards your dream career.",
                        color = SoftWhite,
                        fontSize = 12.sp
                    )

                    Spacer(Modifier.height(15.dp))

                    Row(
                        verticalAlignment =
                            Alignment.CenterVertically
                    ) {

                        Text(
                            "0%",
                            color = Gold,
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(Modifier.width(10.dp))

                        Text(
                            "Preparation completed",
                            color = SoftWhite,
                            fontSize = 12.sp
                        )
                    }
                }

                Spacer(Modifier.height(25.dp))

                Text(
                    "Explore CareerBridge",
                    color = White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.height(5.dp))

                Text(
                    "Choose a module to begin",
                    color = SoftWhite,
                    fontSize = 12.sp
                )

                Spacer(Modifier.height(10.dp))
            }

            items(modules) { module ->

                CareerModuleCard(

                    module = module,

                    onClick = {

                        when (module.title) {

                            "AI Career Assistant" ->
                                onAIChat()

                            "Skill Assessment" ->
                                onAssessment()

                            "Personalized Learning" ->
                                onLearning()

                            "Resume Evaluation" ->
                                onResume()

                            "Interview Preparation" ->
                                onInterview()

                            "Progress Dashboard" ->
                                onProgress()
                        }
                    }
                )
            }

            item {

                Spacer(Modifier.height(10.dp))

                Text(
                    "CareerBridge • AI-Powered Placement Preparation",

                    modifier = Modifier.fillMaxWidth(),

                    textAlign = TextAlign.Center,

                    color = Color(0xFF777C94),

                    fontSize = 11.sp
                )

                Spacer(Modifier.height(25.dp))
            }
        }
    }
}


/* ================================================= */
/*                 CAREER MODULE DATA                */
/* ================================================= */

data class CareerModule(

    val icon: String,

    val title: String,

    val description: String
)


/* ================================================= */
/*                  MODULE CARD                     */
/* ================================================= */

@Composable
fun CareerModuleCard(

    module: CareerModule,

    onClick: () -> Unit
) {

    Button(

        onClick = onClick,

        modifier = Modifier
            .fillMaxWidth()
            .height(88.dp),

        shape = RoundedCornerShape(22.dp),

        colors = ButtonDefaults.buttonColors(
            containerColor = CardColor
        ),

        contentPadding =
            PaddingValues(
                horizontal = 18.dp,
                vertical = 12.dp
            )
    ) {

        Row(

            modifier = Modifier.fillMaxWidth(),

            verticalAlignment =
                Alignment.CenterVertically
        ) {

            Box(

                modifier = Modifier
                    .size(52.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(
                        Brush.linearGradient(
                            colors = listOf(
                                Purple,
                                Blue
                            )
                        )
                    ),

                contentAlignment =
                    Alignment.Center
            ) {

                Text(
                    module.icon,
                    fontSize = 23.sp
                )
            }

            Spacer(Modifier.width(15.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    module.title,
                    color = White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.height(4.dp))

                Text(
                    module.description,
                    color = SoftWhite,
                    fontSize = 11.sp
                )
            }

            Text(
                "›",
                color = Gold,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


/* ================================================= */
/*              AI CAREER ASSISTANT                  */
/* ================================================= */

@Composable
fun CareerBridgeChat(
    onBack: () -> Unit
) {

    var message by remember {
        mutableStateOf("")
    }

    var messages by remember {

        mutableStateOf(
            listOf(
                "AI: Hello! 👋 I'm your CareerBridge AI Assistant.",
                "AI: Ask me anything about placements, skills, careers or interviews."
            )
        )
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Navy
    ) {

        Column(

            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Navy2,
                            Navy
                        )
                    )
                )
        ) {

            Row(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 15.dp,
                        vertical = 15.dp
                    ),

                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                TextButton(
                    onClick = {
                        onBack()
                    }
                ) {

                    Text(
                        "‹",
                        color = White,
                        fontSize = 30.sp
                    )
                }

                Column {

                    Text(
                        "AI Career Assistant",
                        color = White,
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        "CareerBridge AI",
                        color = Gold,
                        fontSize = 11.sp
                    )
                }
            }

            Column(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {

                CareerBridgeLogo(65.dp)

                Spacer(Modifier.height(12.dp))

                Text(
                    "Your Personal Career Coach",
                    color = White,
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.height(5.dp))

                Text(
                    "Get guidance for your placement journey.",
                    color = SoftWhite,
                    fontSize = 12.sp
                )
            }

            Spacer(Modifier.height(20.dp))

            LazyColumn(

                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),

                verticalArrangement =
                    Arrangement.spacedBy(10.dp)
            ) {

                items(messages) { msg ->

                    val isUser =
                        msg.startsWith("You:")

                    Row(

                        modifier = Modifier.fillMaxWidth(),

                        horizontalArrangement =
                            if (isUser)
                                Arrangement.End
                            else
                                Arrangement.Start
                    ) {

                        Box(

                            modifier = Modifier
                                .fillMaxWidth(0.85f)
                                .clip(RoundedCornerShape(18.dp))
                                .background(
                                    if (isUser)
                                        Color(0xFF29205C)
                                    else
                                        CardColor
                                )
                                .padding(15.dp)
                        ) {

                            Text(
                                msg,
                                color = White,
                                fontSize = 13.sp
                            )
                        }
                    }
                }
            }

            Row(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),

                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                OutlinedTextField(

                    value = message,

                    onValueChange = {
                        message = it
                    },

                    modifier = Modifier.weight(1f),

                    singleLine = true,

                    placeholder = {

                        Text(
                            "Ask your career question...",
                            color = Color(0xFF777C94),
                            fontSize = 12.sp
                        )
                    },

                    shape = RoundedCornerShape(18.dp),

                    colors =
                        OutlinedTextFieldDefaults.colors(

                            focusedBorderColor =
                                Purple,

                            unfocusedBorderColor =
                                BorderColor,

                            focusedTextColor =
                                White,

                            unfocusedTextColor =
                                White,

                            cursorColor =
                                Gold
                        )
                )

                Spacer(Modifier.width(8.dp))

                Button(

                    onClick = {

                        if (message.isNotBlank()) {

                            messages =
                                messages +
                                        "You: $message"

                            messages =
                                messages +
                                        "AI: Great question! CareerBridge will help you prepare step-by-step. 🚀"

                            message = ""
                        }
                    },

                    modifier = Modifier.size(58.dp),

                    shape =
                        RoundedCornerShape(18.dp),

                    colors =
                        ButtonDefaults.buttonColors(
                            containerColor = Purple
                        ),

                    contentPadding =
                        PaddingValues(0.dp)
                ) {

                    Text(
                        "➤",
                        color = White,
                        fontSize = 22.sp
                    )
                }
            }
        }
    }
}


/* ================================================= */
/*                 SKILL ASSESSMENT                  */
/* ================================================= */

data class AssessmentQuestion(

    val question: String,

    val options: List<String>,

    val correctAnswer: Int
)


@Composable
fun SkillAssessmentScreen(
    onBack: () -> Unit
) {

    val questions = remember {

        listOf(

            AssessmentQuestion(
                "1. What is the output of 10 + 20?",
                listOf(
                    "20",
                    "30",
                    "40",
                    "50"
                ),
                1
            ),

            AssessmentQuestion(
                "2. Which language is mainly used for Android development?",
                listOf(
                    "Kotlin",
                    "HTML",
                    "SQL",
                    "CSS"
                ),
                0
            ),

            AssessmentQuestion(
                "3. Which data structure follows FIFO?",
                listOf(
                    "Stack",
                    "Queue",
                    "Tree",
                    "Graph"
                ),
                1
            ),

            AssessmentQuestion(
                "4. What does AI stand for?",
                listOf(
                    "Automatic Internet",
                    "Artificial Intelligence",
                    "Advanced Interface",
                    "Application Integration"
                ),
                1
            ),

            AssessmentQuestion(
                "5. Which one is a programming language?",
                listOf(
                    "Python",
                    "Photoshop",
                    "Windows",
                    "Chrome"
                ),
                0
            )
        )
    }

    var selectedAnswers by remember {

        mutableStateOf(
            List(questions.size) {
                -1
            }
        )
    }

    var submitted by remember {
        mutableStateOf(false)
    }

    val score =
        questions.indices.count { index ->

            selectedAnswers[index] ==
                    questions[index].correctAnswer
        }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Navy
    ) {

        Column(

            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Navy2,
                            Navy
                        )
                    )
                )
        ) {

            Row(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 15.dp,
                        vertical = 12.dp
                    ),

                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                TextButton(
                    onClick = {
                        onBack()
                    }
                ) {

                    Text(
                        "‹",
                        color = White,
                        fontSize = 30.sp
                    )
                }

                Column {

                    Text(
                        "Skill Assessment",
                        color = White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        "Aptitude • Technical Skills",
                        color = Gold,
                        fontSize = 11.sp
                    )
                }
            }

            if (submitted) {

                LazyColumn(

                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                ) {

                    item {

                        Spacer(Modifier.height(40.dp))

                        Box(

                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(28.dp))
                                .background(
                                    Brush.linearGradient(
                                        colors = listOf(
                                            Color(0xFF242052),
                                            Color(0xFF182A55)
                                        )
                                    )
                                )
                                .padding(30.dp),

                            contentAlignment =
                                Alignment.Center
                        ) {

                            Column(

                                horizontalAlignment =
                                    Alignment.CenterHorizontally
                            ) {

                                Text(
                                    "🎯",
                                    fontSize = 50.sp
                                )

                                Spacer(Modifier.height(15.dp))

                                Text(
                                    "Assessment Complete!",
                                    color = White,
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )

                                Spacer(Modifier.height(15.dp))

                                Text(
                                    "$score / ${questions.size}",
                                    color = Gold,
                                    fontSize = 42.sp,
                                    fontWeight = FontWeight.ExtraBold
                                )

                                Text(
                                    "Your Score",
                                    color = SoftWhite,
                                    fontSize = 13.sp
                                )

                                Spacer(Modifier.height(20.dp))

                                val resultText = when {

                                    score >= 4 ->
                                        "Excellent! 🌟"

                                    score >= 3 ->
                                        "Good Job! 👍"

                                    score >= 2 ->
                                        "Keep Practicing! 💪"

                                    else ->
                                        "More Practice Needed 📚"
                                }

                                Text(
                                    resultText,
                                    color = White,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }

                        Spacer(Modifier.height(25.dp))

                        Text(
                            "Skill Analysis",
                            color = White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(Modifier.height(12.dp))

                        Column(

                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(20.dp))
                                .background(CardColor)
                                .padding(20.dp)
                        ) {

                            Text(
                                "Your assessment result can be used to identify skill gaps and recommend personalized learning paths.",
                                color = SoftWhite,
                                fontSize = 13.sp
                            )
                        }

                        Spacer(Modifier.height(25.dp))

                        Button(

                            onClick = {

                                submitted = false

                                selectedAnswers =
                                    List(questions.size) {
                                        -1
                                    }
                            },

                            modifier = Modifier.fillMaxWidth(),

                            shape =
                                RoundedCornerShape(18.dp),

                            colors =
                                ButtonDefaults.buttonColors(
                                    containerColor = Purple
                                )
                        ) {

                            Text(
                                "TAKE ASSESSMENT AGAIN",
                                color = White,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }

            } else {

                LazyColumn(

                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp),

                    verticalArrangement =
                        Arrangement.spacedBy(15.dp)
                ) {

                    item {

                        Spacer(Modifier.height(10.dp))

                        Text(
                            "Test Your Skills 🎯",
                            color = White,
                            fontSize = 25.sp,
                            fontWeight = FontWeight.ExtraBold
                        )

                        Spacer(Modifier.height(5.dp))

                        Text(
                            "Answer the questions and discover your current skill level.",
                            color = SoftWhite,
                            fontSize = 12.sp
                        )

                        Spacer(Modifier.height(10.dp))
                    }

                    items(
                        questions.indices.toList()
                    ) { index ->

                        val question =
                            questions[index]

                        Column(

                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(22.dp))
                                .background(CardColor)
                                .padding(18.dp)
                        ) {

                            Text(
                                question.question,
                                color = White,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(Modifier.height(12.dp))

                            question.options
                                .forEachIndexed { optionIndex, option ->

                                    val selected =
                                        selectedAnswers[index] ==
                                                optionIndex

                                    Button(

                                        onClick = {

                                            val updated =
                                                selectedAnswers
                                                    .toMutableList()

                                            updated[index] =
                                                optionIndex

                                            selectedAnswers =
                                                updated
                                        },

                                        modifier =
                                            Modifier
                                                .fillMaxWidth()
                                                .padding(
                                                    vertical = 4.dp
                                                ),

                                        shape =
                                            RoundedCornerShape(14.dp),

                                        colors =
                                            ButtonDefaults.buttonColors(

                                                containerColor =
                                                    if (selected)
                                                        Purple
                                                    else
                                                        Color(0xFF20253F)
                                            )
                                    ) {

                                        Text(
                                            option,
                                            color = White,
                                            modifier =
                                                Modifier.fillMaxWidth(),
                                            textAlign =
                                                TextAlign.Start,
                                            fontSize = 13.sp
                                        )
                                    }
                                }
                        }
                    }

                    item {

                        Button(

                            onClick = {
                                submitted = true
                            },

                            modifier = Modifier
                                .fillMaxWidth()
                                .height(58.dp),

                            shape =
                                RoundedCornerShape(18.dp),

                            colors =
                                ButtonDefaults.buttonColors(
                                    containerColor = Purple
                                )
                        ) {

                            Text(
                                "SUBMIT ASSESSMENT  →",
                                color = White,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(Modifier.height(30.dp))
                    }
                }
            }
        }
    }
}


/* ================================================= */
/*              PERSONALIZED LEARNING                */
/* ================================================= */

data class LearningTopic(

    val number: String,

    val title: String,

    val description: String,

    val level: String
)


@Composable
fun PersonalizedLearningScreen(
    onBack: () -> Unit
) {

    val learningTopics = listOf(

        LearningTopic(
            "01",
            "Programming Fundamentals",
            "Variables, loops, functions and problem solving",
            "Beginner"
        ),

        LearningTopic(
            "02",
            "Data Structures & Algorithms",
            "Arrays, strings, stacks, queues and algorithms",
            "Intermediate"
        ),

        LearningTopic(
            "03",
            "Database & SQL",
            "SQL queries, database concepts and normalization",
            "Intermediate"
        ),

        LearningTopic(
            "04",
            "Web & Application Development",
            "Build practical projects and applications",
            "Intermediate"
        ),

        LearningTopic(
            "05",
            "Interview Preparation",
            "Technical questions, HR questions and communication",
            "Advanced"
        )
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Navy
    ) {

        LazyColumn(

            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Navy2,
                            Navy
                        )
                    )
                )
                .padding(horizontal = 20.dp),

            verticalArrangement =
                Arrangement.spacedBy(14.dp)
        ) {

            item {

                Spacer(Modifier.height(20.dp))

                Row(

                    modifier = Modifier.fillMaxWidth(),

                    verticalAlignment =
                        Alignment.CenterVertically
                ) {

                    TextButton(
                        onClick = {
                            onBack()
                        }
                    ) {

                        Text(
                            "‹",
                            color = White,
                            fontSize = 30.sp
                        )
                    }

                    Column {

                        Text(
                            "Personalized Learning",
                            color = White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            "Your AI Learning Path",
                            color = Gold,
                            fontSize = 11.sp
                        )
                    }
                }

                Spacer(Modifier.height(20.dp))

                Text(
                    "Your Learning Journey 📚",
                    color = White,
                    fontSize = 27.sp,
                    fontWeight = FontWeight.ExtraBold
                )

                Spacer(Modifier.height(6.dp))

                Text(
                    "Based on your skills, build the knowledge needed for your dream career.",
                    color = SoftWhite,
                    fontSize = 13.sp
                )

                Spacer(Modifier.height(20.dp))

                Column(

                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(24.dp))
                        .background(
                            Brush.linearGradient(
                                colors = listOf(
                                    Color(0xFF242052),
                                    Color(0xFF182A55)
                                )
                            )
                        )
                        .padding(20.dp)
                ) {

                    Row(

                        modifier =
                            Modifier.fillMaxWidth(),

                        horizontalArrangement =
                            Arrangement.SpaceBetween
                    ) {

                        Column {

                            Text(
                                "Skill Gap Analysis",
                                color = White,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(Modifier.height(5.dp))

                            Text(
                                "Areas recommended for improvement",
                                color = SoftWhite,
                                fontSize = 11.sp
                            )
                        }

                        Text(
                            "AI",
                            color = Gold,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                    }

                    Spacer(Modifier.height(18.dp))

                    SkillGapRow(
                        "Problem Solving",
                        "Needs Practice"
                    )

                    SkillGapRow(
                        "Data Structures",
                        "Needs Practice"
                    )

                    SkillGapRow(
                        "Communication",
                        "Improve"
                    )

                    SkillGapRow(
                        "Programming",
                        "Developing"
                    )
                }

                Spacer(Modifier.height(20.dp))

                Text(
                    "Recommended Learning Path",
                    color = White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.height(4.dp))

                Text(
                    "Follow these topics step-by-step",
                    color = SoftWhite,
                    fontSize = 12.sp
                )

                Spacer(Modifier.height(8.dp))
            }

            items(learningTopics) { topic ->

                LearningTopicCard(topic)
            }

            item {

                Spacer(Modifier.height(10.dp))

                Column(

                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(22.dp))
                        .background(CardColor)
                        .padding(20.dp)
                ) {

                    Text(
                        "⏱️ Weekly Learning Goal",
                        color = White,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(Modifier.height(8.dp))

                    Text(
                        "5 hours per week",
                        color = Gold,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.ExtraBold
                    )

                    Spacer(Modifier.height(5.dp))

                    Text(
                        "Practice consistently to improve your placement readiness.",
                        color = SoftWhite,
                        fontSize = 12.sp
                    )
                }

                Spacer(Modifier.height(25.dp))

                Text(
                    "CareerBridge • Personalized for You",

                    modifier = Modifier.fillMaxWidth(),

                    textAlign = TextAlign.Center,

                    color = Color(0xFF777C94),

                    fontSize = 11.sp
                )

                Spacer(Modifier.height(25.dp))
            }
        }
    }
}


/* ================================================= */
/*                  SKILL GAP ROW                    */
/* ================================================= */

@Composable
fun SkillGapRow(

    skill: String,

    status: String
) {

    Row(

        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 7.dp),

        horizontalArrangement =
            Arrangement.SpaceBetween
    ) {

        Text(
            skill,
            color = White,
            fontSize = 13.sp
        )

        Text(
            status,
            color = Gold,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }
}


/* ================================================= */
/*                 LEARNING CARD                     */
/* ================================================= */

@Composable
fun LearningTopicCard(

    topic: LearningTopic
) {

    Row(

        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(22.dp))
            .background(CardColor)
            .padding(17.dp),

        verticalAlignment =
            Alignment.CenterVertically
    ) {

        Box(

            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(
                    Brush.linearGradient(
                        colors = listOf(
                            Purple,
                            Blue
                        )
                    )
                ),

            contentAlignment =
                Alignment.Center
        ) {

            Text(
                topic.number,
                color = White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(Modifier.width(14.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                topic.title,
                color = White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(4.dp))

            Text(
                topic.description,
                color = SoftWhite,
                fontSize = 11.sp
            )

            Spacer(Modifier.height(6.dp))

            Text(
                topic.level,
                color = Gold,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Text(
            "›",
            color = Gold,
            fontSize = 27.sp,
            fontWeight = FontWeight.Bold
        )
    }
}


/* ================================================= */
/*                RESUME EVALUATION                  */
/* ================================================= */

@Composable
fun ResumeEvaluationScreen(

    onBack: () -> Unit
) {

    var resumeUploaded by remember {
        mutableStateOf(false)
    }

    var evaluated by remember {
        mutableStateOf(false)
    }

    Surface(

        modifier = Modifier.fillMaxSize(),

        color = Navy
    ) {

        LazyColumn(

            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Navy2,
                            Navy
                        )
                    )
                )
                .padding(horizontal = 20.dp),

            verticalArrangement =
                Arrangement.spacedBy(14.dp)
        ) {

            item {

                Spacer(Modifier.height(20.dp))

                Row(

                    modifier = Modifier.fillMaxWidth(),

                    verticalAlignment =
                        Alignment.CenterVertically
                ) {

                    TextButton(
                        onClick = {
                            onBack()
                        }
                    ) {

                        Text(
                            "‹",
                            color = White,
                            fontSize = 30.sp
                        )
                    }

                    Column {

                        Text(
                            "Resume Evaluation",
                            color = White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            "AI Resume Analyzer",
                            color = Gold,
                            fontSize = 11.sp
                        )
                    }
                }

                Spacer(Modifier.height(20.dp))

                Text(
                    "Improve Your Resume 📄",
                    color = White,
                    fontSize = 27.sp,
                    fontWeight = FontWeight.ExtraBold
                )

                Spacer(Modifier.height(6.dp))

                Text(
                    "Analyze your resume and get personalized improvement suggestions.",
                    color = SoftWhite,
                    fontSize = 13.sp
                )

                Spacer(Modifier.height(20.dp))
            }

            item {

                Column(

                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(24.dp))
                        .background(CardColor)
                        .padding(22.dp),

                    horizontalAlignment =
                        Alignment.CenterHorizontally
                ) {

                    Text(
                        "📄",
                        fontSize = 50.sp
                    )

                    Spacer(Modifier.height(12.dp))

                    Text(
                        if (resumeUploaded)
                            "Resume Selected"
                        else
                            "Upload Your Resume",

                        color = White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(Modifier.height(7.dp))

                    Text(
                        if (resumeUploaded)
                            "resume.pdf"
                        else
                            "PDF format recommended",

                        color = SoftWhite,
                        fontSize = 12.sp
                    )

                    Spacer(Modifier.height(20.dp))

                    Button(

                        onClick = {

                            resumeUploaded = true
                        },

                        modifier = Modifier
                            .fillMaxWidth()
                            .height(55.dp),

                        shape =
                            RoundedCornerShape(17.dp),

                        colors =
                            ButtonDefaults.buttonColors(
                                containerColor = Purple
                            )
                    ) {

                        Text(
                            if (resumeUploaded)
                                "RESUME SELECTED ✓"
                            else
                                "SELECT RESUME",

                            color = White,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            item {

                Button(

                    onClick = {

                        if (resumeUploaded) {

                            evaluated = true
                        }
                    },

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(58.dp),

                    shape =
                        RoundedCornerShape(18.dp),

                    colors =
                        ButtonDefaults.buttonColors(

                            containerColor =
                                if (resumeUploaded)
                                    Blue
                                else
                                    Color(0xFF30354D)
                        )
                ) {

                    Text(
                        "ANALYZE RESUME  →",
                        color = White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            if (evaluated) {

                item {

                    Spacer(Modifier.height(5.dp))

                    Text(
                        "AI Evaluation Result",
                        color = White,
                        fontSize = 21.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                item {

                    Column(

                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(24.dp))
                            .background(
                                Brush.linearGradient(
                                    colors = listOf(
                                        Color(0xFF242052),
                                        Color(0xFF182A55)
                                    )
                                )
                            )
                            .padding(24.dp),

                        horizontalAlignment =
                            Alignment.CenterHorizontally
                    ) {

                        Text(
                            "82%",
                            color = Gold,
                            fontSize = 44.sp,
                            fontWeight = FontWeight.ExtraBold
                        )

                        Text(
                            "Resume Score",
                            color = SoftWhite,
                            fontSize = 13.sp
                        )

                        Spacer(Modifier.height(20.dp))

                        Text(
                            "Good Resume! 👍",
                            color = White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                item {

                    ResumeFeedbackCard(
                        "✓",
                        "Strengths",
                        "Clear education details\n" +
                                "Good technical skills\n" +
                                "Project experience included"
                    )
                }

                item {

                    ResumeFeedbackCard(
                        "!",
                        "Areas to Improve",
                        "Add measurable achievements\n" +
                                "Improve professional summary\n" +
                                "Add relevant keywords"
                    )
                }

                item {

                    ResumeFeedbackCard(
                        "💡",
                        "AI Suggestions",
                        "Use action-oriented words\n" +
                                "Highlight your strongest projects\n" +
                                "Customize your resume for each job role"
                    )
                }
            }

            item {

                Spacer(Modifier.height(20.dp))

                Text(
                    "CareerBridge • AI-Powered Resume Evaluation",

                    modifier = Modifier.fillMaxWidth(),

                    textAlign = TextAlign.Center,

                    color = Color(0xFF777C94),

                    fontSize = 11.sp
                )

                Spacer(Modifier.height(20.dp))
            }
        }
    }
}


/* ================================================= */
/*                RESUME FEEDBACK CARD               */
/* ================================================= */

@Composable
fun ResumeFeedbackCard(

    icon: String,

    title: String,

    description: String
) {

    Column(

        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(CardColor)
            .padding(20.dp)
    ) {

        Row(

            verticalAlignment =
                Alignment.CenterVertically
        ) {

            Text(
                icon,
                color = Gold,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.width(10.dp))

            Text(
                title,
                color = White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(Modifier.height(10.dp))

        Text(
            description,
            color = SoftWhite,
            fontSize = 12.sp,
            lineHeight = 20.sp
        )
    }
}


/* ================================================= */
/*              INTERVIEW DATA                      */
/* ================================================= */

data class InterviewQuestion(

    val question: String,

    val category: String
)


/* ================================================= */
/*            INTERVIEW PREPARATION                  */
/* ================================================= */

@Composable
fun InterviewPreparationScreen(

    onBack: () -> Unit
) {

    val questions = remember {

        listOf(

            InterviewQuestion(
                "Tell me about yourself.",
                "HR Interview"
            ),

            InterviewQuestion(
                "What are your strengths?",
                "HR Interview"
            ),

            InterviewQuestion(
                "Explain one project you have worked on.",
                "Technical Interview"
            ),

            InterviewQuestion(
                "What is the difference between a stack and a queue?",
                "Technical Interview"
            ),

            InterviewQuestion(
                "Why should we hire you?",
                "HR Interview"
            )
        )
    }

    var selectedQuestion by remember {
        mutableStateOf(0)
    }

    var answer by remember {
        mutableStateOf("")
    }

    var evaluated by remember {
        mutableStateOf(false)
    }

    var interviewStarted by remember {
        mutableStateOf(false)
    }

    Surface(

        modifier = Modifier.fillMaxSize(),

        color = Navy
    ) {

        if (!interviewStarted) {

            LazyColumn(

                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Navy2,
                                Navy
                            )
                        )
                    )
                    .padding(horizontal = 20.dp),

                verticalArrangement =
                    Arrangement.spacedBy(15.dp)
            ) {

                item {

                    Spacer(Modifier.height(20.dp))

                    Row(

                        modifier =
                            Modifier.fillMaxWidth(),

                        verticalAlignment =
                            Alignment.CenterVertically
                    ) {

                        TextButton(
                            onClick = {
                                onBack()
                            }
                        ) {

                            Text(
                                "‹",
                                color = White,
                                fontSize = 30.sp
                            )
                        }

                        Column {

                            Text(
                                "Interview Preparation",
                                color = White,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                "AI Mock Interview",
                                color = Gold,
                                fontSize = 11.sp
                            )
                        }
                    }

                    Spacer(Modifier.height(25.dp))

                    Box(

                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(26.dp))
                            .background(
                                Brush.linearGradient(
                                    colors = listOf(
                                        Color(0xFF242052),
                                        Color(0xFF182A55)
                                    )
                                )
                            )
                            .padding(25.dp),

                        contentAlignment =
                            Alignment.Center
                    ) {

                        Column(

                            horizontalAlignment =
                                Alignment.CenterHorizontally
                        ) {

                            Text(
                                "🎤",
                                fontSize = 55.sp
                            )

                            Spacer(Modifier.height(12.dp))

                            Text(
                                "AI Mock Interview",
                                color = White,
                                fontSize = 25.sp,
                                fontWeight = FontWeight.ExtraBold,
                                textAlign = TextAlign.Center
                            )

                            Spacer(Modifier.height(8.dp))

                            Text(
                                "Practice real interview questions and improve your confidence.",
                                color = SoftWhite,
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                    }

                    Spacer(Modifier.height(25.dp))

                    Text(
                        "Interview Features",
                        color = White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(Modifier.height(12.dp))
                }

                item {

                    InterviewFeatureCard(
                        "🎯",
                        "HR Interview",
                        "Practice common HR and behavioral questions."
                    )
                }

                item {

                    InterviewFeatureCard(
                        "💻",
                        "Technical Interview",
                        "Prepare for technical and project-based questions."
                    )
                }

                item {

                    InterviewFeatureCard(
                        "🤖",
                        "AI Feedback",
                        "Get feedback and an interview performance score."
                    )
                }

                item {

                    Spacer(Modifier.height(10.dp))

                    Button(

                        onClick = {

                            interviewStarted = true
                            evaluated = false
                            selectedQuestion = 0
                            answer = ""
                        },

                        modifier = Modifier
                            .fillMaxWidth()
                            .height(58.dp),

                        shape =
                            RoundedCornerShape(18.dp),

                        colors =
                            ButtonDefaults.buttonColors(
                                containerColor = Purple
                            )
                    ) {

                        Text(
                            "START MOCK INTERVIEW  →",
                            color = White,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(Modifier.height(30.dp))

                    Text(
                        "CareerBridge • AI Interview Coach",

                        modifier = Modifier.fillMaxWidth(),

                        textAlign = TextAlign.Center,

                        color = Color(0xFF777C94),

                        fontSize = 11.sp
                    )

                    Spacer(Modifier.height(20.dp))
                }
            }

        } else {

            LazyColumn(

                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Navy2,
                                Navy
                            )
                        )
                    )
                    .padding(horizontal = 20.dp),

                verticalArrangement =
                    Arrangement.spacedBy(15.dp)
            ) {

                item {

                    Spacer(Modifier.height(20.dp))

                    Row(

                        modifier =
                            Modifier.fillMaxWidth(),

                        verticalAlignment =
                            Alignment.CenterVertically
                    ) {

                        TextButton(

                            onClick = {

                                interviewStarted = false
                            }
                        ) {

                            Text(
                                "‹",
                                color = White,
                                fontSize = 30.sp
                            )
                        }

                        Column {

                            Text(
                                "AI Mock Interview",
                                color = White,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                "Question ${selectedQuestion + 1} of ${questions.size}",
                                color = Gold,
                                fontSize = 11.sp
                            )
                        }
                    }

                    Spacer(Modifier.height(20.dp))
                }

                if (!evaluated) {

                    item {

                        Column(

                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(24.dp))
                                .background(CardColor)
                                .padding(22.dp)
                        ) {

                            Text(
                                questions[selectedQuestion].category,
                                color = Gold,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(Modifier.height(12.dp))

                            Text(
                                questions[selectedQuestion].question,
                                color = White,
                                fontSize = 21.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    item {

                        Text(
                            "Your Answer",
                            color = White,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(Modifier.height(8.dp))

                        OutlinedTextField(

                            value = answer,

                            onValueChange = {
                                answer = it
                            },

                            modifier = Modifier
                                .fillMaxWidth()
                                .height(170.dp),

                            placeholder = {

                                Text(
                                    "Type your answer here...",
                                    color = Color(0xFF777C94),
                                    fontSize = 12.sp
                                )
                            },

                            colors =
                                OutlinedTextFieldDefaults.colors(

                                    focusedBorderColor =
                                        Purple,

                                    unfocusedBorderColor =
                                        BorderColor,

                                    focusedTextColor =
                                        White,

                                    unfocusedTextColor =
                                        White,

                                    cursorColor =
                                        Gold
                                ),

                            shape =
                                RoundedCornerShape(18.dp)
                        )
                    }

                    item {

                        Button(

                            onClick = {

                                if (
                                    selectedQuestion <
                                    questions.size - 1
                                ) {

                                    selectedQuestion++

                                    answer = ""

                                } else {

                                    evaluated = true
                                }
                            },

                            modifier = Modifier
                                .fillMaxWidth()
                                .height(58.dp),

                            shape =
                                RoundedCornerShape(18.dp),

                            colors =
                                ButtonDefaults.buttonColors(
                                    containerColor = Purple
                                )
                        ) {

                            Text(

                                if (
                                    selectedQuestion <
                                    questions.size - 1
                                )
                                    "NEXT QUESTION  →"
                                else
                                    "FINISH INTERVIEW  ✓",

                                color = White,

                                fontSize = 14.sp,

                                fontWeight =
                                    FontWeight.Bold
                            )
                        }
                    }

                } else {

                    item {

                        Spacer(Modifier.height(20.dp))

                        Column(

                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(28.dp))
                                .background(
                                    Brush.linearGradient(
                                        colors = listOf(
                                            Color(0xFF242052),
                                            Color(0xFF182A55)
                                        )
                                    )
                                )
                                .padding(28.dp),

                            horizontalAlignment =
                                Alignment.CenterHorizontally
                        ) {

                            Text(
                                "🎤",
                                fontSize = 50.sp
                            )

                            Spacer(Modifier.height(12.dp))

                            Text(
                                "Interview Complete!",
                                color = White,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )

                            Spacer(Modifier.height(20.dp))

                            Text(
                                "86%",
                                color = Gold,
                                fontSize = 46.sp,
                                fontWeight = FontWeight.ExtraBold
                            )

                            Text(
                                "Interview Performance Score",
                                color = SoftWhite,
                                fontSize = 12.sp
                            )

                            Spacer(Modifier.height(18.dp))

                            Text(
                                "Good Performance! 👍",
                                color = White,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    item {

                        InterviewFeedbackCard(
                            "✓",
                            "Communication",
                            "Your answers show good communication and confidence."
                        )
                    }

                    item {

                        InterviewFeedbackCard(
                            "✓",
                            "Technical Knowledge",
                            "You demonstrate a developing understanding of technical concepts."
                        )
                    }

                    item {

                        InterviewFeedbackCard(
                            "!",
                            "Improvement Area",
                            "Give more specific examples when explaining your projects and experience."
                        )
                    }

                    item {

                        InterviewFeedbackCard(
                            "💡",
                            "AI Recommendation",
                            "Practice 15 minutes daily and prepare STAR-based answers for HR questions."
                        )
                    }

                    item {

                        Button(

                            onClick = {

                                interviewStarted = false
                                evaluated = false
                                selectedQuestion = 0
                                answer = ""
                            },

                            modifier = Modifier
                                .fillMaxWidth()
                                .height(58.dp),

                            shape =
                                RoundedCornerShape(18.dp),

                            colors =
                                ButtonDefaults.buttonColors(
                                    containerColor = Purple
                                )
                        ) {

                            Text(
                                "PRACTICE AGAIN",
                                color = White,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    item {

                        Spacer(Modifier.height(20.dp))

                        Text(
                            "CareerBridge • AI Interview Evaluation",

                            modifier = Modifier.fillMaxWidth(),

                            textAlign = TextAlign.Center,

                            color = Color(0xFF777C94),

                            fontSize = 11.sp
                        )

                        Spacer(Modifier.height(20.dp))
                    }
                }
            }
        }
    }
}


/* ================================================= */
/*             INTERVIEW FEATURE CARD                */
/* ================================================= */

@Composable
fun InterviewFeatureCard(

    icon: String,

    title: String,

    description: String
) {

    Row(

        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(CardColor)
            .padding(18.dp),

        verticalAlignment =
            Alignment.CenterVertically
    ) {

        Box(

            modifier = Modifier
                .size(52.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(
                    Brush.linearGradient(
                        colors = listOf(
                            Purple,
                            Blue
                        )
                    )
                ),

            contentAlignment =
                Alignment.Center
        ) {

            Text(
                icon,
                fontSize = 23.sp
            )
        }

        Spacer(Modifier.width(15.dp))

        Column {

            Text(
                title,
                color = White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(5.dp))

            Text(
                description,
                color = SoftWhite,
                fontSize = 11.sp
            )
        }
    }
}


/* ================================================= */
/*            INTERVIEW FEEDBACK CARD                */
/* ================================================= */

@Composable
fun InterviewFeedbackCard(

    icon: String,

    title: String,

    description: String
) {

    Column(

        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(CardColor)
            .padding(20.dp)
    ) {

        Row(

            verticalAlignment =
                Alignment.CenterVertically
        ) {

            Text(
                icon,
                color = Gold,
                fontSize = 20.sp
            )

            Spacer(Modifier.width(10.dp))

            Text(
                title,
                color = White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(Modifier.height(10.dp))

        Text(
            description,
            color = SoftWhite,
            fontSize = 12.sp,
            lineHeight = 20.sp
        )
    }
}


/* ================================================= */
/*                PROGRESS DASHBOARD                 */
/* ================================================= */

@Composable
fun ProgressDashboardScreen(
    onBack: () -> Unit
) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Navy
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Navy2,
                            Navy
                        )
                    )
                )
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {

            item {
                Spacer(Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextButton(onClick = onBack) {
                        Text(
                            "‹",
                            color = White,
                            fontSize = 30.sp
                        )
                    }

                    Column {
                        Text(
                            "Progress Dashboard",
                            color = White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            "Track your preparation",
                            color = Gold,
                            fontSize = 11.sp
                        )
                    }
                }

                Spacer(Modifier.height(20.dp))

                Text(
                    "Your Progress 📊",
                    color = White,
                    fontSize = 27.sp,
                    fontWeight = FontWeight.ExtraBold
                )

                Spacer(Modifier.height(6.dp))

                Text(
                    "Monitor your skills, learning and placement readiness.",
                    color = SoftWhite,
                    fontSize = 13.sp
                )

                Spacer(Modifier.height(20.dp))
            }

            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(26.dp))
                        .background(
                            Brush.linearGradient(
                                colors = listOf(
                                    Color(0xFF242052),
                                    Color(0xFF182A55)
                                )
                            )
                        )
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "68%",
                        color = Gold,
                        fontSize = 46.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Text(
                        "Overall Preparation",
                        color = White,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        "Keep going — you are building strong placement readiness!",
                        color = SoftWhite,
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }

            item {
                Text(
                    "Performance Overview",
                    color = White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            item {
                ProgressMetricCard("🎯", "Skill Assessment", "80%", "Good")
            }

            item {
                ProgressMetricCard("📚", "Learning Progress", "60%", "In Progress")
            }

            item {
                ProgressMetricCard("📄", "Resume Score", "82%", "Good")
            }

            item {
                ProgressMetricCard("🎤", "Interview Score", "86%", "Excellent")
            }

            item {
                Text(
                    "Skill Development",
                    color = White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(22.dp))
                        .background(CardColor)
                        .padding(20.dp)
                ) {
                    SkillProgressRow("Programming", 0.75f)
                    SkillProgressRow("Problem Solving", 0.55f)
                    SkillProgressRow("Communication", 0.65f)
                    SkillProgressRow("Data Structures", 0.50f)
                }
            }

            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(22.dp))
                        .background(CardColor)
                        .padding(20.dp)
                ) {
                    Text(
                        "⏱️ Weekly Learning Goal",
                        color = White,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        "3 / 5 hours",
                        color = Gold,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        "60% completed this week",
                        color = SoftWhite,
                        fontSize = 12.sp
                    )
                }
            }

            item {
                Text(
                    "Recent Activity",
                    color = White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            item {
                ProgressActivityCard("✓", "Completed Skill Assessment", "Score: 80%")
            }

            item {
                ProgressActivityCard("✓", "Resume Evaluation Completed", "Score: 82%")
            }

            item {
                ProgressActivityCard("✓", "Mock Interview Completed", "Score: 86%")
            }

            item {
                ProgressActivityCard("📚", "Learning Path Started", "3 hours completed")
            }

            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(22.dp))
                        .background(
                            Brush.linearGradient(
                                colors = listOf(
                                    Color(0xFF242052),
                                    Color(0xFF182A55)
                                )
                            )
                        )
                        .padding(20.dp)
                ) {
                    Text(
                        "💡 Recommended Next Step",
                        color = White,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        "Focus on Data Structures and Problem Solving to improve your placement readiness.",
                        color = SoftWhite,
                        fontSize = 12.sp,
                        lineHeight = 20.sp
                    )
                }
            }

            item {
                Spacer(Modifier.height(10.dp))
                Text(
                    "CareerBridge • AI-Powered Progress Tracking",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = Color(0xFF777C94),
                    fontSize = 11.sp
                )
                Spacer(Modifier.height(20.dp))
            }
        }
    }
}

@Composable
fun ProgressMetricCard(
    icon: String,
    title: String,
    score: String,
    status: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(CardColor)
            .padding(18.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(
                    Brush.linearGradient(
                        colors = listOf(Purple, Blue)
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(icon, fontSize = 22.sp)
        }

        Spacer(Modifier.width(14.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                title,
                color = White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(4.dp))
            Text(
                status,
                color = SoftWhite,
                fontSize = 11.sp
            )
        }

        Text(
            score,
            color = Gold,
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold
        )
    }
}

@Composable
fun SkillProgressRow(
    skill: String,
    progress: Float
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(skill, color = White, fontSize = 13.sp)
            Text(
                "${(progress * 100).toInt()}%",
                color = Gold,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(Modifier.height(7.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFF2A2F48))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(progress)
                    .height(8.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(Purple, Blue)
                        )
                    )
            )
        }
    }
}

@Composable
fun ProgressActivityCard(
    icon: String,
    title: String,
    subtitle: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .background(CardColor)
            .padding(17.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            icon,
            color = Gold,
            fontSize = 20.sp
        )
        Spacer(Modifier.width(12.dp))
        Column {
            Text(
                title,
                color = White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(4.dp))
            Text(
                subtitle,
                color = SoftWhite,
                fontSize = 11.sp
            )
        }
    }
}


/* ================================================= */
/*                     PREVIEW                       */
/* ================================================= */

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun CareerBridgePreview() {

    MaterialTheme {

        CareerBridgeApp()
    }
}
