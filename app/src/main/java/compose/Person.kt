package compose

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable

@Composable
fun Person(
    viewModel = hiltViewModel()
) {
    Row {
        AsyncImage(
            model = "https://example.com/image.jpg",
            contentDescription = null,
        )
    }
}