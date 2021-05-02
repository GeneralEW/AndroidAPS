package info.nightscout.androidaps.plugins.pump.omnipod.dash.driver

import info.nightscout.androidaps.plugins.pump.omnipod.dash.driver.event.PodEvent
import info.nightscout.androidaps.plugins.pump.omnipod.dash.driver.pod.definition.AlertConfiguration
import info.nightscout.androidaps.plugins.pump.omnipod.dash.driver.pod.definition.AlertTrigger
import info.nightscout.androidaps.plugins.pump.omnipod.dash.driver.pod.definition.AlertType
import info.nightscout.androidaps.plugins.pump.omnipod.dash.driver.pod.definition.BasalProgram
import info.nightscout.androidaps.plugins.pump.omnipod.dash.driver.pod.definition.BeepType
import info.nightscout.androidaps.plugins.pump.omnipod.dash.driver.pod.response.ResponseType
import io.reactivex.Observable
import java.util.*

interface OmnipodDashManager {

    fun activatePodPart1(lowReservoirAlertTrigger: AlertTrigger.ReservoirVolumeTrigger?): Observable<PodEvent>

    fun activatePodPart2(basalProgram: BasalProgram): Observable<PodEvent>

    fun getStatus(type: ResponseType.StatusResponseType): Observable<PodEvent>

    fun setBasalProgram(basalProgram: BasalProgram): Observable<PodEvent>

    fun suspendDelivery(): Observable<PodEvent>

    fun setTime(): Observable<PodEvent>

    fun setTempBasal(rate: Double, durationInMinutes: Short): Observable<PodEvent>

    fun stopTempBasal(): Observable<PodEvent>

    fun bolus(units: Double, confirmationBeeps: Boolean, completionBeeps: Boolean): Observable<PodEvent>

    fun stopBolus(): Observable<PodEvent>

    fun playBeep(beepType: BeepType): Observable<PodEvent>

    fun programAlerts(alertConfigurations: List<AlertConfiguration>): Observable<PodEvent>

    fun silenceAlerts(alertTypes: EnumSet<AlertType>): Observable<PodEvent>

    fun deactivatePod(): Observable<PodEvent>
}