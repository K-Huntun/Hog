import SwiftUI
import log

struct ContentView: View {

	var body: some View {
        Button(action: {
            HogKt.logd(tag: "Hog", msg: "Hello", tr: nil)
        }) {
            Text("Hello, Hog")
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
