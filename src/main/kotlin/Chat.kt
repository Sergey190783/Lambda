class Chat(val userId: Int, val friendId: Int, val chatId: Int) {
    private val messages: MutableList<Message> = mutableListOf()
    fun addMessage(message: Message) {
        if (message.text.isNotEmpty())
            messages.add(message)
    }

    fun editMessage(id: Int, text: String) {
        messages.find { it.id == id }?.text = text
    }

    fun removeMessage(id: Int): Boolean {
        return messages.removeIf { it.id == id }
    }

    fun isRead(): Boolean {
        return messages.last().read
    }

    fun getMessages(): List<Message> {
        return messages
    }

    fun getMessages(index: Int, number: Int): List<Message> {
        return messages.subList(index, index + number)
    }

    fun markMessagesAsRead(messageId: Int, number: Int) {
        val index = indexOfMessage(messageId)
        for (i in index..(index + number)) {
            messages[i].read = true
        }
    }
    fun indexOfMessage(messageId: Int):Int{
        return messages.indexOfFirst { it.id == messageId }
    }

    fun isEmptyChat(): Boolean {
        return messages.isEmpty()
    }
}
