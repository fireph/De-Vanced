/*
 * Forked from:
 * https://gitlab.com/ReVanced/revanced-patches/-/blob/main/patches/src/main/kotlin/app/revanced/patches/messenger/inbox/HideActiveNowTrayPatch.kt
 */
package app.morphe.patches.messenger.inbox

import app.morphe.patches.shared.compat.AppCompatibilities
import app.morphe.patcher.extensions.InstructionExtensions.replaceInstruction
import app.morphe.patcher.patch.bytecodePatch

@Suppress("unused")
val hideFriendsInboxTrayPatch = bytecodePatch(
    name = "Hide friends inbox tray",
    description = "Hides the top user horizontal tray (Active Now and Notes) in the inbox.",
) {
    compatibleWith(AppCompatibilities.MESSENGER)

    execute {
        FriendsInboxTrayFingerprint.method.replaceInstruction(0, "invoke-static {}, Lcom/google/common/collect/ImmutableList;->of()Lcom/google/common/collect/ImmutableList;")
        FriendsInboxTrayFingerprint.method.replaceInstruction(3, "move-result-object v0")
        FriendsInboxTrayFingerprint.method.replaceInstruction(4, "return-object v0")
    }
}
